package com.jiwon.android_github_search.data

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Type

data class GithubRepositoryOwner(
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val avatarUrl: String
)
