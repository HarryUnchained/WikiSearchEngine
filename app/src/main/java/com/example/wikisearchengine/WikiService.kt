package com.example.wikisearchengine

import com.example.wikisearchengine.models.WikiSearchModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://en.wikipedia.org/w/"

interface WikiInterface {

    @GET("api.php?action=query&format=json&list=search")
    fun getWikiProfile(
        @Query("srsearch") srsearch: String
    ): Call<WikiSearchModel>

    companion object {

        fun create(): WikiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(WikiInterface::class.java)
        }

    }

}