package com.jiwon.android_github_search.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jiwon.android_github_search.data.GithubRepository
import com.jiwon.android_github_search.repository.GithubServiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject constructor(
    val githubServiceRepository: GithubServiceRepository
) : ViewModel(){
    private val TAG = GithubViewModel::class.java.simpleName

    val githubRepositories = MutableLiveData(emptyList<GithubRepository>())

    fun searchRepository(query : String) = viewModelScope.launch(Dispatchers.IO){
        githubServiceRepository.searchRepository(query).catch { exception ->
            // TODO handle error
            Log.d(TAG, exception.stackTraceToString())
        }.collect {
            // TODO display result
            it.forEach {
                Log.d(TAG,"$it")
            }
            githubRepositories.postValue(it)
        }
    }
}