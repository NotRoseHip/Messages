package org.fossify.messages.extensions.virustotal.common

import com.google.gson.annotations.SerializedName
import org.fossify.messages.extensions.virustotal.VirusTotal

fun getScannerResult(scanner : Scanner) : VirusTotal.ScanResult {
    return when (scanner.result) {
        "phishing" -> VirusTotal.ScanResult.Phishing
        "malicious" -> VirusTotal.ScanResult.Malicious
        "spam" -> VirusTotal.ScanResult.Spam
        "suspicious" -> VirusTotal.ScanResult.Suspicious
        "clean" -> VirusTotal.ScanResult.Clean
        else -> VirusTotal.ScanResult.Unknown
    }
}

data class Scanner (

  @SerializedName("category"    ) var category   : String? = null,
  @SerializedName("engine_name" ) var engineName : String? = null,
  @SerializedName("method"      ) var method     : String? = null,
  @SerializedName("result"      ) var result     : String? = null

)
