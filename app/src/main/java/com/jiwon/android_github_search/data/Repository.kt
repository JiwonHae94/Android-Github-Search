package com.jiwon.android_github_search.data

import com.google.gson.annotations.SerializedName

data class Repository(
    @SerializedName("name") val name: String,
    @SerializedName("owner") val owner: RepositoryOwner,
    @SerializedName("private") val isPrivate: Boolean,
    @SerializedName("description") val description: String?,
    @SerializedName("url") val url: String,
    @SerializedName("forks") val forks: Long,
    @SerializedName("stargazers_count") val stargazersCount: Long
)
