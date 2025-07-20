package org.fossify.messages.extensions.virustotal

import com.google.gson.annotations.SerializedName
import org.fossify.messages.extensions.virustotal.scan.Data


data class ResponseScanUrl (

    @SerializedName("data" ) var data : Data? = Data()

)
