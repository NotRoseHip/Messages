package org.fossify.messages.extensions.virustotal

import android.text.Spanned
import android.text.style.URLSpan
import android.text.util.Linkify
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.fossify.commons.extensions.beVisible
import org.fossify.messages.R
import org.fossify.messages.databinding.ItemMessageBinding
import org.fossify.messages.extensions.gson.gson
import org.fossify.messages.extensions.virustotal.common.Results
import org.fossify.messages.extensions.virustotal.common.Scanner
import org.fossify.messages.extensions.virustotal.common.getScannerResult
import org.fossify.messages.extensions.virustotal.common.memberNames
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

object VirusTotal {
    var apiKey : String = ""

    private val client = OkHttpClient()

    private val scanQueue = mutableSetOf<Long>()

    fun pushQueue(id : Long) {
        scanQueue.add(id)
    }

    fun popQueue(id : Long) : Boolean {
        return scanQueue.remove(id)
    }

    enum class ScanResult {
        Malicious,
        Phishing,
        Suspicious,
        Spam,
        Clean,
        Unknown
    }

    private fun clickableLinks(longText: CharSequence) : Array<out URLSpan>? {
        return try {
            (longText as Spanned).getSpans(0, longText.length, URLSpan::class.java)
        } catch (e: Exception) {
            arrayOf()
        }
    }

    private inline fun <reified T> vtResponse(
        string: String
    ) : T {
        return gson.fromJson(string, T::class.java)
    }

    private fun getVTScore(info: Results) : ScanResult {
        val res = mutableSetOf<ScanResult>()

        for (prop in Results::class.members) {
            if (memberNames.contains(prop.name)) {
                val scanner: Scanner = prop.call(info) as Scanner
                res.add(getScannerResult(scanner))
            }
        }

        return if (res.contains(ScanResult.Phishing)) {
            ScanResult.Phishing
        } else if (res.contains(ScanResult.Malicious)) {
            ScanResult.Malicious
        } else if (res.contains(ScanResult.Spam)) {
            ScanResult.Spam
        } else if (res.contains(ScanResult.Suspicious)) {
            ScanResult.Suspicious
        } else if (res.contains(ScanResult.Clean)) {
            ScanResult.Clean
        } else {
            return ScanResult.Unknown
        }
    }

    fun scanMessageURL(item : ItemMessageBinding) {
        clickableLinks(item.threadMessageBody.text)?.forEach {
            CoroutineScope(Dispatchers.IO).launch {
                val response = requestGetURL(it.url)
                withContext(Dispatchers.Main) {
                    item.threadUrlsScanResult.apply {
                        beVisible()
                        when(response) {
                            ScanResult.Malicious -> setImageResource(R.drawable.scan_malicious)
                            ScanResult.Suspicious, ScanResult.Spam -> setImageResource(R.drawable.scan_spam)
                            ScanResult.Phishing -> setImageResource(R.drawable.scan_phishing)
                            ScanResult.Clean -> setImageResource(R.drawable.scan_safe)
                            ScanResult.Unknown -> setImageResource(R.drawable.scan_unknown)
                        }
                    }
                    item.threadMessageBody.apply {
                        when(response) {
                            ScanResult.Malicious, ScanResult.Suspicious, ScanResult.Phishing, ScanResult.Spam -> {
                                autoLinkMask = Linkify.EMAIL_ADDRESSES
                                text = text
                            }
                            else -> {} //TODO()
                        }
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalEncodingApi::class)
    private fun requestGetURL(url : String) : ScanResult {
        val url64 = Base64.UrlSafe.encode(url.encodeToByteArray()).replace("=", "")
        var stats = Results()

        var request = Request.Builder()
            .url("https://www.virustotal.com/api/v3/urls/${url64}")
            .get()
            .addHeader("accept", "application/json")
            .addHeader("x-apikey", apiKey)
            .build()
        try {
            var response = client.newCall(request).execute()
            if (response.code == 404) {
                val mediaType = "application/x-www-form-urlencoded".toMediaTypeOrNull()
                val reqBody = "url=$url".toRequestBody(mediaType)
                request = Request.Builder()
                    .url("https://www.virustotal.com/api/v3/urls")
                    .post(reqBody)
                    .addHeader("accept", "application/json")
                    .addHeader("x-apikey", apiKey)
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .build()
                try {
                    response = client.newCall(request).execute()
                    val id = vtResponse<ResponseScanUrl>(response.body.string()).data?.id
                    request = Request.Builder()
                        .url("https://www.virustotal.com/api/v3/analyses/${id}")
                        .get()
                        .addHeader("accept", "application/json")
                        .addHeader("x-apikey", apiKey)
                        .build()
                    response = client.newCall(request).execute()
                    stats = vtResponse<ResponseAnalyses>(response.body.string()).data?.attributes?.results!!
                } catch (e: Exception) {
                    Log.println(Log.ERROR, null, "Scan request: " + e.message!!)
                }
            } else {
                stats = vtResponse<ResponseUrl>(response.body.string()).data?.attributes?.lastAnalysisResults!!
            }
        } catch (e: Exception) {
            Log.println(Log.ERROR, null, "URL request : " + e.message!!)
        }

        return getVTScore(stats)
    }
}
