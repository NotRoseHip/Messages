package org.fossify.messages.extensions.virustotal.url

import com.google.gson.annotations.SerializedName


data class TotalVotes (

  @SerializedName("harmless"  ) var harmless  : Int? = null,
  @SerializedName("malicious" ) var malicious : Int? = null

)
