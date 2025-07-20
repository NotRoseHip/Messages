package org.fossify.messages.extensions.virustotal.url

import com.google.gson.annotations.SerializedName
import org.fossify.messages.extensions.virustotal.common.Results
import org.fossify.messages.extensions.virustotal.common.Stats


data class Attributes (

    @SerializedName("categories"                        ) var categories                    : Categories?              = Categories(),
    @SerializedName("favicon"                           ) var favicon                       : Favicon?                 = Favicon(),
    @SerializedName("first_submission_date"             ) var firstSubmissionDate           : Int?                     = null,
    @SerializedName("has_content"                       ) var hasContent                    : Boolean?                 = null,
    @SerializedName("html_meta"                         ) var htmlMeta                      : HtmlMeta?                = HtmlMeta(),
    @SerializedName("last_analysis_date"                ) var lastAnalysisDate              : Int?                     = null,
    @SerializedName("last_analysis_results"             ) var lastAnalysisResults           : Results?                 = Results(),
    @SerializedName("last_analysis_stats"               ) var lastAnalysisStats             : Stats?                   = Stats(),
    @SerializedName("last_final_url"                    ) var lastFinalUrl                  : String?                  = null,
    @SerializedName("last_http_response_code"           ) var lastHttpResponseCode          : Int?                     = null,
    @SerializedName("last_http_response_content_length" ) var lastHttpResponseContentLength : Int?                     = null,
    @SerializedName("last_http_response_content_sha256" ) var lastHttpResponseContentSha256 : String?                  = null,
    @SerializedName("last_http_response_cookies"        ) var lastHttpResponseCookies       : LastHttpResponseCookies? = LastHttpResponseCookies(),
    @SerializedName("last_http_response_headers"        ) var lastHttpResponseHeaders       : LastHttpResponseHeaders? = LastHttpResponseHeaders(),
    @SerializedName("last_modification_date"            ) var lastModificationDate          : Int?                     = null,
    @SerializedName("last_submission_date"              ) var lastSubmissionDate            : Int?                     = null,
    @SerializedName("outgoing_links"                    ) var outgoingLinks                 : ArrayList<String>        = arrayListOf(),
    @SerializedName("reputation"                        ) var reputation                    : Int?                     = null,
    @SerializedName("redirection_chain"                 ) var redirectionChain              : ArrayList<String>        = arrayListOf(),
    @SerializedName("tags"                              ) var tags                          : ArrayList<String>        = arrayListOf(),
    @SerializedName("targeted_brand"                    ) var targetedBrand                 : TargetedBrand?           = TargetedBrand(),
    @SerializedName("times_submitted"                   ) var timesSubmitted                : Int?                     = null,
    @SerializedName("title"                             ) var title                         : String?                  = null,
    @SerializedName("total_votes"                       ) var totalVotes                    : TotalVotes?              = TotalVotes(),
    @SerializedName("trackers"                          ) var trackers                      : Trackers?                = Trackers(),
    @SerializedName("url"                               ) var url                           : String?                  = null

)
