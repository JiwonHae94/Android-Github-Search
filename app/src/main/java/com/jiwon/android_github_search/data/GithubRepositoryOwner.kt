package com.jiwon.android_github_search.data

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import java.lang.NullPointerException
import java.lang.reflect.Type

data class GithubRepositoryOwner(
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val avatarUrl: String
){
    companion object{
        private val deserializer = object : JsonDeserializer<GithubRepositoryOwner>{
            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?,
            ): GithubRepositoryOwner {
                val jsonObject = json?.asJsonObject ?: throw NullPointerException("Response contains null response")
                return GithubRepositoryOwner(
                    login = jsonObject["login"].asString,
                    avatarUrl = jsonObject["avatarUrl"].asString
                )
            }
        }

        val parser = GsonBuilder().registerTypeAdapter(GithubRepository::class.java, deserializer).create()
    }
}
