package org.fossify.messages.extensions.virustotal.scan

import com.google.gson.annotations.SerializedName
import org.fossify.messages.extensions.virustotal.common.Links


data class Data (

    @SerializedName("type"  ) var type  : String? = null,
    @SerializedName("id"    ) var id    : String? = null,
    @SerializedName("links" ) var links : Links?  = Links()

)
