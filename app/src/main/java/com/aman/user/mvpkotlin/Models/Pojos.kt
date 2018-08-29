package com.aman.user.mvpkotlin.Models

import com.google.gson.annotations.SerializedName

object Pojos {
    data class Result(@SerializedName("query")
                      val query: Query)

    data class Searchinfo(@SerializedName("totalhits")
                          val totalhits: Int = 0)

    data class MessageEvents(var strname: String,
                             var strAge: Int,
                             var strDob: String
    )

    data class Query(@SerializedName("search")
                     val search: List<SearchItem>?,
                     @SerializedName("searchinfo")
                     val searchinfo: Searchinfo)

    data class SearchItemEvent(var item: SearchItem)
    data class ArrSearchItemEvent(var arritem: MutableList<SearchItem>)

    data class SearchItem(@SerializedName("title")
                          val title: String = "",
                          @SerializedName("wordcount")
                          val wordcount: String = "")
}