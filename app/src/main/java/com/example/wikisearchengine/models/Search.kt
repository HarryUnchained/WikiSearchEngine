package com.example.wikisearchengine.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Search(
    @SerializedName("ns")
    @Expose
    val ns: Int,
    @SerializedName("pageid")
    @Expose
    val pageid: Int,
    @SerializedName("size")
    @Expose
    val size: Int,
    @SerializedName("snippet")
    @Expose
    val snippet: String,
    @SerializedName("timestamp")
    @Expose
    val timestamp: String,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("wordcount")
    @Expose
    val wordcount: Int
)