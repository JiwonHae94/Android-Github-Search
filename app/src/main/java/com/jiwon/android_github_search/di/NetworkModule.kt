package com.jiwon.android_github_search.di

import com.jiwon.android_github_search.api.RetrofitAPI
import com.jiwon.android_github_search.api.services.GithubApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideGithubApi() = RetrofitAPI.create(
        clz = GithubApiService.SearchInterface::class.java,
        baseURL = GithubApiService.BASE_URL,
        gson = GithubApiService.ApiGson
    )

}