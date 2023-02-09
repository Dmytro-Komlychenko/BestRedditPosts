package com.example.bestredditposts.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetTopPostsUseCase

class MainViewModelFactory(
    private val getTopPostsUseCase: GetTopPostsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getTopPostsUseCase = getTopPostsUseCase
        ) as T
    }
}
