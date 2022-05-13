package com.jiwon.android_github_search.data

import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Type

data class GithubRepository(
    @SerializedName("name") val name: String,
    @SerializedName("owner") val owner: String,
    @SerializedName("private") val isPrivate: Boolean,
    @SerializedName("description") val description: String?,
    @SerializedName("url") val url: String,
    @SerializedName("forks") val forks: Long,
    @SerializedName("stargazers_count") val stargazersCount: Long
) {
    companion object{
        private val TAG = GithubRepository::class.java.simpleName
        private val deserializer = object : JsonDeserializer<GithubRepository>{
            override fun deserialize(
                json: JsonElement,
                typeOfT: Type?,
                context: JsonDeserializationContext?,
            ): GithubRepository {
                val jsonObj = json.asJsonObject
                Log.d(TAG, jsonObj.toString())

                return GithubRepository(
                    name = jsonObj["name"].asString,
                    owner = "",
                    isPrivate = jsonObj["private"].asBoolean,
                    description = jsonObj["description"].asString,
                    url = jsonObj["url"].asString,
                    forks = jsonObj["forks"].asLong,
                    stargazersCount = jsonObj["stargazers_count"].asLong
                )
            }
        }
        val parser = GsonBuilder().registerTypeAdapter(GithubRepository::class.java, deserializer).create()
    }
}
