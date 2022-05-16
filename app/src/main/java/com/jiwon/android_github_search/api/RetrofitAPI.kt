package com.jiwon.android_github_search.api

import com.google.gson.Gson
import com.jiwon.android_github_search.api.services.GithubApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitAPI {
    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        //.addInterceptor(GithubApiService.applicationInterceptor)
        .build()


    fun <T> create(
        clz : Class<T>,
        baseURL : String,
        gson : Gson
    ) = Retrofit.Builder()
        .baseUrl(baseURL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(clz)
}