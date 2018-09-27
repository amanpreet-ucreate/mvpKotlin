package com.aman.user.mvpkotlin.Models

import com.google.gson.annotations.SerializedName

object Pojos {

    data class Result(@SerializedName("query")
                      val query: Query)

    data class Searchinfo(@SerializedName("totalhits")
                          val totalhits: Int = 0)

    data class Query(@SerializedName("search")
                     val search: List<SearchItem>?,
                     @SerializedName("searchinfo")
                     val searchinfo: Searchinfo)

    data class SearchItem(@SerializedName("title")
                          val title: String = "",
                          @SerializedName("wordcount")
                          val wordcount: String = "")
}