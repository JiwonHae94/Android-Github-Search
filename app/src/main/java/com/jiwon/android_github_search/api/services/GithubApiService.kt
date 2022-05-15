package com.jiwon.android_github_search.api.services

import com.google.gson.GsonBuilder
import com.jiwon.android_github_search.data.GithubRepositoryResponse
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import org.json.JSONObject
import retrofit2.http.GET
import retrofit2.http.Query

class GithubApiService {
    interface SearchInterface{
        @GET("search/repositories")
        suspend fun searchRepository(
            @Query("q") query : String
        ) : GithubRepositoryResponse
    }

    companion object {
        val BASE_URL = "https://api.github.com/"
        val ApiGson = GsonBuilder()
            .registerTypeAdapter(GithubRepositoryResponse::class.java,
                GithubRepositoryResponse.deserializer)
            .create()
    }
}