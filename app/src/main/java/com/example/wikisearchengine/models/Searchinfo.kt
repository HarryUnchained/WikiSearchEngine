package com.example.wikisearchengine.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Searchinfo(
    @SerializedName("totalhits")
    @Expose
    val totalhits: Int
)