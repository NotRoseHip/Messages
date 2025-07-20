package org.fossify.messages.extensions.virustotal.url

import com.google.gson.annotations.SerializedName


data class GoogleTagManager (

  @SerializedName("id"        ) var id        : String? = null,
  @SerializedName("timestamp" ) var timestamp : Int?    = null,
  @SerializedName("url"       ) var url       : String? = null

)
