package com.example.bestredditposts.presentation.postList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetTopPostsUseCase

class PostsViewModelFactory(
    private val getTopPostsUseCase: GetTopPostsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostsViewModel(
            getTopPostsUseCase = getTopPostsUseCase
        ) as T
    }
}
