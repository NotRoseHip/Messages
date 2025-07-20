package org.fossify.messages.extensions.virustotal.url

import com.google.gson.annotations.SerializedName


data class LastHttpResponseCookies (

  @SerializedName("PHPSESSID" ) var PHPSESSID : String? = null,
  @SerializedName("SameSite"  ) var SameSite  : String? = null,
  @SerializedName("__cfduid"  ) var _cfduid   : String? = null,
  @SerializedName("sessid"    ) var sessid    : String? = null

)
