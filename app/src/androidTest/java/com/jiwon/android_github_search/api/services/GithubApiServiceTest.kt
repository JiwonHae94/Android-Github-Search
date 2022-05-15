package com.jiwon.android_github_search.api.services

import com.jiwon.android_github_search.api.RetrofitAPI
import com.jiwon.android_github_search.repository.GithubServiceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.junit.Test

class GithubApiServiceTest{
    @Test
    fun testRestAPI(){
        val githubSearchAPI = RetrofitAPI.create(
            GithubApiService.SearchInterface::class.java,
            GithubApiService.BASE_URL,
            GithubApiService.ApiGson
        )

        val repository = GithubServiceRepository(githubSearchAPI)

        CoroutineScope(Dispatchers.IO).launch {
            repository.searchRepository("yolo").collect {
                println(it.toString())
            }
        }

    }


}