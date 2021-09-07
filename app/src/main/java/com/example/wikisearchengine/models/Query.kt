package com.example.wikisearchengine.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Query(
    @SerializedName("search")
    @Expose
    val search: List<Search>,

    @SerializedName("searchinfo")
    @Expose
    val searchinfo: Searchinfo
)