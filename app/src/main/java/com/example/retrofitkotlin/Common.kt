package com.example.retrofitkotlin

object Common {
    private val BASE_URL = "https://www.googleapis.com/books/v1/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}