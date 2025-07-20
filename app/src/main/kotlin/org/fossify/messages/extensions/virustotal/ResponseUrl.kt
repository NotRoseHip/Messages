package org.fossify.messages.extensions.virustotal

import com.google.gson.annotations.SerializedName
import org.fossify.messages.extensions.virustotal.url.Data

data class ResponseUrl (

    @SerializedName("data" ) var data : Data? = Data()

)
