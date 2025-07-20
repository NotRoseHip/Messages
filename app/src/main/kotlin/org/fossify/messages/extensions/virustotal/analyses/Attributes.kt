package org.fossify.messages.extensions.virustotal.analyses

import com.google.gson.annotations.SerializedName
import org.fossify.messages.extensions.virustotal.common.Results
import org.fossify.messages.extensions.virustotal.common.Stats


data class Attributes (

    @SerializedName("date"    ) var date    : Int?     = null,
    @SerializedName("results" ) var results : Results? = Results(),
    @SerializedName("stats"   ) var stats   : Stats?   = Stats(),
    @SerializedName("status"  ) var status  : String?  = null

)
