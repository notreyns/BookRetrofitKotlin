package com.example.retrofitkotlin

import com.example.retrofitkotlin.model.Item
import com.example.retrofitkotlin.model.MainModel
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @GET("volumes?maxResults=10")
    fun getMovieList(@Query("q") search_txt:String): Call<MainModel>
}