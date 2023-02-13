package com.example.bestredditposts.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.model.Post
import com.example.domain.usecase.GetTopPostsUseCase

class MainViewModel(
    private val getTopPostsUseCase: GetTopPostsUseCase
) : ViewModel() {

    val errorMessage = MutableLiveData<String>()

    fun getPostList(): LiveData<PagingData<Post>> {
        return getTopPostsUseCase.execute().cachedIn(viewModelScope)
    }

}