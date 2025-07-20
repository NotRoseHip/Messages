package org.fossify.messages.extensions.virustotal.url

import com.google.gson.annotations.SerializedName


data class LastHttpResponseHeaders (

  @SerializedName("cache-control"     ) var cachecontrol     : String? = null,
  @SerializedName("cf-cache-status"   ) var cfcachestatus    : String? = null,
  @SerializedName("cf-ray"            ) var cfray            : String? = null,
  @SerializedName("cf-request-id"     ) var cfrequestid      : String? = null,
  @SerializedName("connection"        ) var connection       : String? = null,
  @SerializedName("content-type"      ) var contenttype      : String? = null,
  @SerializedName("date"              ) var date             : String? = null,
  @SerializedName("expires"           ) var expires          : String? = null,
  @SerializedName("pragma"            ) var pragma           : String? = null,
  @SerializedName("server"            ) var server           : String? = null,
  @SerializedName("set-cookie"        ) var setcookie        : String? = null,
  @SerializedName("transfer-encoding" ) var transferencoding : String? = null

)
