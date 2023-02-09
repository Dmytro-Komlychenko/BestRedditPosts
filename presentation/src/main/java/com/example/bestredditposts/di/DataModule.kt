package com.example.bestredditposts.di

import com.example.domain.repositoryI.RedditRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideRedditRepository(): RedditRepository {
        return com.example.data.repository.RedditRepository()
    }
}