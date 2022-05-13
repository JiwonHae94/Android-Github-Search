package com.jiwon.android_github_search.api.services

import android.util.Log
import com.google.gson.GsonBuilder
import com.jiwon.android_github_search.data.GithubRepositoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

class GithubApiService {
    interface SearchInterface{
        @GET("search/repositories")
        suspend fun searchRepository(
            @Query("q") query : String
        ) : GithubRepositoryResponse
    }

    sealed class StatusCode(
        val code : Int
    ) {
        object Success : StatusCode(200)
        object NotModified : StatusCode(304)
        object Forbidden : StatusCode(403)
        object ResourceNotFound : StatusCode(404)
        object ValidationFailed : StatusCode(422)
    }

    companion object{
        val BASE_URL = "https://github.developer.com/"//"https://api.github.com/"
        val ApiGson = GsonBuilder()
            .registerTypeAdapter(GithubRepositoryResponse::class.java, GithubRepositoryResponse.deserializer)
            .create()


//        val applicationInterceptor = object : Interceptor{
//            override fun intercept(chain: Interceptor.Chain): Response {
//
//                Log.d("REST API", "interceptor : ${chain.call().execute().code}")
//                when(chain.call().execute().code){
//                    StatusCode.Success.code -> NullPointerException(StatusCode.Success.code.toString())
//                    StatusCode.NotModified.code -> NullPointerException(StatusCode.NotModified.code.toString())
//                    StatusCode.Forbidden.code -> NullPointerException(StatusCode.Forbidden.code.toString())
//                    StatusCode.ResourceNotFound.code -> NullPointerException(StatusCode.ResourceNotFound.code.toString())
//                    StatusCode.ValidationFailed.code -> NullPointerException(StatusCode.ValidationFailed.code.toString())
//                }
//                return chain.proceed(chain.request())
//            }
//        }
    }


}