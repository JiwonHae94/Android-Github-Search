package com.jiwon.android_github_search.repository

import com.jiwon.android_github_search.api.services.GithubApiService
import kotlinx.coroutines.flow.flow

class GithubServiceRepository(
    val api : GithubApiService.SearchInterface
) {
    private val TAG = GithubServiceRepository::class.java.simpleName

    suspend fun searchRepository(query : String) = flow {
        val out = api.searchRepository(query)
        emit(out.repositories)
    }
}