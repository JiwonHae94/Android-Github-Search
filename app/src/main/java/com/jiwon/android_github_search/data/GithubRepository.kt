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
    @SerializedName("full_name") val fullName: String,
    @SerializedName("owner") val owner: GithubRepositoryOwner,
    @SerializedName("private") val isPrivate: Boolean,
    @SerializedName("description") val description: String?,
    @SerializedName("url") val url: String,
    @SerializedName("forks") val forks: Long,
    @SerializedName("stargazers_count") val stargazersCount: Long,
    @SerializedName("language") val language: String,
    @SerializedName("license") val license : String?,
    @SerializedName("topcis") val topics : List<String>,
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
                    fullName = jsonObj["name"].asString,
                    name = jsonObj["name"].asString,
                    owner = GithubRepositoryOwner.parser.fromJson(jsonObj["owner"].asJsonObject, GithubRepositoryOwner::class.java),
                    isPrivate = jsonObj["private"].asBoolean,
                    description = jsonObj["description"].asString,
                    url = jsonObj["url"].asString,
                    forks = jsonObj["forks"].asLong,
                    stargazersCount = jsonObj["stargazers_count"].asLong,
                    license = "test", //TODO check license
                    language = jsonObj["language"].asString,
                    topics = jsonObj["topics"].asJsonArray.map { it.toString() }
                )
            }
        }
        val parser = GsonBuilder().registerTypeAdapter(GithubRepository::class.java, deserializer).create()
    }
}
