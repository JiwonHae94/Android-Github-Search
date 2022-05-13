package com.jiwon.android_github_search.data

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import java.lang.NullPointerException
import java.lang.reflect.Type

data class GithubRepositoryResponse(
    @SerializedName("total_count") val totalRepoCount: Long,
    @SerializedName("incomplete_results") val isResultIncomplete: Boolean,
    @SerializedName("items") val repositories: List<GithubRepository>
) {
    companion object{
        private val TAG = GithubRepositoryResponse::class.java.simpleName

        val deserializer = object : JsonDeserializer<GithubRepositoryResponse>{
            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?,
            ): GithubRepositoryResponse {
                val jsonObject = json?.asJsonObject ?: throw NullPointerException("Response contains null response")

                return GithubRepositoryResponse(
                    totalRepoCount = jsonObject["total_count"].asLong,
                    isResultIncomplete = jsonObject["incomplete_results"].asBoolean,
                    repositories = jsonObject["items"].asJsonArray.map {
                        GithubRepository.parser.fromJson(it, GithubRepository::class.java)
                    }
                )
            }
        }
    }
}