package org.fossify.messages.extensions.virustotal.url

import com.google.gson.annotations.SerializedName


data class Trackers (

  @SerializedName("Google Tag Manager" ) var GoogleTagManager : ArrayList<GoogleTagManager> = arrayListOf()

)
