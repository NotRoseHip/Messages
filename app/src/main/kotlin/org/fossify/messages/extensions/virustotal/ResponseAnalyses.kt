package org.fossify.messages.extensions.virustotal

import com.google.gson.annotations.SerializedName
import org.fossify.messages.extensions.virustotal.analyses.Data

data class ResponseAnalyses (

    @SerializedName("data" ) var data : Data? = Data()

)
