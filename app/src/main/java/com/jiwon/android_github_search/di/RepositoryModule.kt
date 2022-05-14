package com.jiwon.android_github_search.di

import com.jiwon.android_github_search.api.services.GithubApiService
import com.jiwon.android_github_search.repository.GithubServiceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideGithubRepository(
        searchAPI : GithubApiService.SearchInterface
    ) = GithubServiceRepository(searchAPI)
}