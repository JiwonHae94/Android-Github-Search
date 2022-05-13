package com.jiwon.android_github_search.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitAPI {
    private val httpClient = OkHttpClient
        .Builder()
        .build()

    fun <T> create(
        clz : Class<T>,
        baseURL : String
    ) = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(clz)

}