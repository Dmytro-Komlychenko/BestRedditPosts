package com.example.bestredditposts.di

import com.example.domain.repositoryI.RedditRepository
import com.example.domain.usecase.GetTopPostsUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetTopPostsUseCase(repository: RedditRepository)
            : GetTopPostsUseCase {
        return GetTopPostsUseCase(redditRepository = repository)
    }


}