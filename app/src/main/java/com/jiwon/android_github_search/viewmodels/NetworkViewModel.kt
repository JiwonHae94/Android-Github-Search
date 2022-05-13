package com.jiwon.android_github_search.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.jiwon.android_github_search.repository.GithubServiceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.withContext

class NetworkViewModel(
    val githubServiceRepository: GithubServiceRepository
) : ViewModel(){
    private val TAG = NetworkViewModel::class.java.simpleName


    suspend fun searchRepository(
        query : String
    ) = withContext(Dispatchers.IO){
        githubServiceRepository.searchRepository(query).catch { exception ->
            // TODO handle error
            Log.d(TAG, exception.stackTraceToString())
        }.collect {
            // TODO display result
            Log.d(TAG, "$it")
        }
    }
}