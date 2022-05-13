package com.jiwon.android_github_search.api.services

import com.google.gson.GsonBuilder
import com.jiwon.android_github_search.data.GithubRepositoryResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

class GithubApiService {
    interface SearchInterface{
        @GET("search/repositories")
        suspend fun searchRepository(
            @Query("q") query : String
        ) : GithubRepositoryResponse
    }

    companion object{
        val BASE_URL = "https://api.github.com/"
        val ApiGson = GsonBuilder()
            .registerTypeAdapter(GithubRepositoryResponse::class.java, GithubRepositoryResponse.deserializer)
            .create()
    }


}