package org.fossify.messages.extensions.virustotal.analyses

import com.google.gson.annotations.SerializedName


data class Data (

  @SerializedName("attributes" ) var attributes : Attributes? = Attributes(),
  @SerializedName("id"         ) var id         : String?     = null,
  @SerializedName("type"       ) var type       : String?     = null

)
