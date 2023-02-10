package com.example.bestredditposts.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Post
import com.example.domain.usecase.GetTopPostsUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getTopPostsUseCase: GetTopPostsUseCase
) : ViewModel() {

    val liveDataPost: MutableLiveData<ArrayList<Post?>> = MutableLiveData()

    init {
        getPosts()
    }
    fun getPosts() {
        viewModelScope.launch {
            try {
                liveDataPost.value = getTopPostsUseCase.execute()
            } catch (e: Exception) {
            }

        }
    }

}