package org.fossify.messages.extensions.virustotal.common

import com.google.gson.annotations.SerializedName


data class Stats (

  @SerializedName("harmless"   ) var harmless   : Int? = null,
  @SerializedName("malicious"  ) var malicious  : Int? = null,
  @SerializedName("suspicious" ) var suspicious : Int? = null,
  @SerializedName("timeout"    ) var timeout    : Int? = null,
  @SerializedName("undetected" ) var undetected : Int? = null

)
