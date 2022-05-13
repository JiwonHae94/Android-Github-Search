package com.jiwon.android_github_search.data

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @SerializedName("total_count") val totalRepoCount: Int,
    @SerializedName("incomplete_results") val isResultIncomplete: Boolean,
    @SerializedName("items") val repositories: List<Repository>
)