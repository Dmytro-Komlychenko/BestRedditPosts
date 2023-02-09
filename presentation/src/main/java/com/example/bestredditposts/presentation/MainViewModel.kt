package com.example.bestredditposts.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Post
import com.example.domain.usecase.GetTopPostsUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getTopPostsUseCase: GetTopPostsUseCase
) : ViewModel() {

    val liveDataPost: MutableLiveData<Post> = MutableLiveData()

    fun getPosts() {
        viewModelScope.launch {
            liveDataPost.value = getTopPostsUseCase.execute()
        }
    }

}