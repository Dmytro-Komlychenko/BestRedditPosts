package com.example.bestredditposts.di

import android.content.Context
import com.example.bestredditposts.presentation.main.MainViewModelFactory
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
    ): MainViewModelFactory {
        return MainViewModelFactory(
            getTopPostsUseCase = getTopPostsUseCase,
        )
    }
}
