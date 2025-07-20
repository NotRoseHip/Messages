package org.fossify.messages.extensions.virustotal.url

import com.google.gson.annotations.SerializedName
import org.fossify.messages.extensions.virustotal.common.Links


data class Data (

    @SerializedName("attributes" ) var attributes : Attributes? = Attributes(),
    @SerializedName("id"         ) var id         : String?     = null,
    @SerializedName("links"      ) var links      : Links?      = Links(),
    @SerializedName("type"       ) var type       : String?     = null

)
