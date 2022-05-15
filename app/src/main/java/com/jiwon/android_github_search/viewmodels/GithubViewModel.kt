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
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject constructor(
    val githubServiceRepository: GithubServiceRepository
) : ViewModel(){
    private val TAG = GithubViewModel::class.java.simpleName

    val githubRepositories = MutableLiveData(emptyList<GithubRepository>())
    val responseMessage = MutableLiveData("recycler view is currently empty")

    fun searchRepository(query : String) = viewModelScope.launch(Dispatchers.IO){
        // reset current recyclerview list
        githubRepositories.postValue(emptyList())

        // request repository from github
        githubServiceRepository.searchRepository(query).catch { exception ->
            when(exception){
                is HttpException -> {
                    handleServiceException(exception.code(), exception.message())
                }
                else -> Log.e(TAG, exception.stackTraceToString())
            }
        }.collectLatest {
            githubRepositories.postValue(it)
        }
    }

    /**
     *
     */
    private fun handleServiceException(
        errorCode : Int,
        errorMessage : String
    ){
        responseMessage.postValue("(#$errorCode) $errorMessage")
    }
}