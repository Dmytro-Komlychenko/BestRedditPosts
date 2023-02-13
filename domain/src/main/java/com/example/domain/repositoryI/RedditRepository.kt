package com.example.domain.repositoryI

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.domain.model.Post

interface RedditRepository {
    fun getTopPosts(): LiveData<PagingData<Post>>
}