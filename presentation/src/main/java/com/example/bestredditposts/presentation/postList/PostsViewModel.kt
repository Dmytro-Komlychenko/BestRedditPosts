package com.example.bestredditposts.presentation.postList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.model.Post
import com.example.domain.usecase.GetTopPostsUseCase

class PostsViewModel(
    private val getTopPostsUseCase: GetTopPostsUseCase
) : ViewModel() {

    val errorMessage = MutableLiveData<String>()

    val posts: MutableLiveData<PagingData<Post>> = MutableLiveData()

    val updatePosts: MutableLiveData<Boolean> = MutableLiveData(false)

    fun getPostList(): LiveData<PagingData<Post>> {
        return getTopPostsUseCase.execute().cachedIn(viewModelScope)
    }

}