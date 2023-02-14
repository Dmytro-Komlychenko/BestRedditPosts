package com.example.bestredditposts.di

import android.content.Context
import com.example.bestredditposts.presentation.postList.PostsViewModelFactory
import com.example.domain.usecase.GetTopPostsUseCase
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        getTopPostsUseCase: GetTopPostsUseCase,
    ): PostsViewModelFactory {
        return PostsViewModelFactory(
            getTopPostsUseCase = getTopPostsUseCase,
        )
    }
}
