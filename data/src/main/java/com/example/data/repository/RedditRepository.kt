package com.example.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.*
import com.example.data.PostPagingSource
import com.example.domain.model.Post
import kotlinx.coroutines.delay

class RedditRepository : com.example.domain.repositoryI.RedditRepository {


    override fun getTopPosts(): LiveData<PagingData<Post>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false,
                initialLoadSize = 1
            ),
            pagingSourceFactory = {
                PostPagingSource()
            }
            , initialKey = 1
        ).liveData
    }

    companion object {
        const val PAGE_SIZE = 25
    }
}