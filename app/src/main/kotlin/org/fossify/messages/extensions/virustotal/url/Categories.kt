package org.fossify.messages.extensions.virustotal.url

import com.google.gson.annotations.SerializedName


data class Categories (

  @SerializedName("BitDefender" )             var BitDefender :          String?   = null,
  @SerializedName("Forcepoint ThreatSeeker" ) var ForcepointThreatSeeker : String? = null

)
