package org.fossify.messages.extensions.virustotal.url

import com.google.gson.annotations.SerializedName


data class Favicon (

  @SerializedName("dhash"   ) var dhash  : String? = null,
  @SerializedName("raw_md5" ) var rawMd5 : String? = null

)
