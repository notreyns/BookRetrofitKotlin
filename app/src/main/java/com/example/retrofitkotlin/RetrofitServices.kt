package com.example.retrofitkotlin

import com.example.retrofitkotlin.model.Item
import com.example.retrofitkotlin.model.MainModel
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @GET("volumes?q=haruki")
    fun getMovieList(): Call<MainModel>
}