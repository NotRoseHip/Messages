package org.fossify.messages.extensions.virustotal.url

import com.google.gson.annotations.SerializedName


data class HtmlMeta (

  @SerializedName("description" ) var description : ArrayList<String> = arrayListOf(),
  @SerializedName("sessid"      ) var sessid      : ArrayList<String> = arrayListOf(),
  @SerializedName("viewport"    ) var viewport    : ArrayList<String> = arrayListOf()

)
