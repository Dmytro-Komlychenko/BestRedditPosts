package com.example.data.repository

import com.example.data.storage.retrofit.RetrofitInstance
import com.example.domain.model.Post

class RedditRepository : com.example.domain.repositoryI.RedditRepository {

    override suspend fun getTopPosts(): Post? {
        return RetrofitInstance.api.getTopPosts().body()?.posts?.posts?.get(3)?.data?.let {
            mapPostToDomain(it)
        }
    }

    private fun mapPostToDomain(dataPost: com.example.data.storage.model.Post): Post {
        return Post(
            dataPost.approvedAtUtc,
            dataPost.authorFullname,
            dataPost.thumbnail,
            dataPost.commentsCount
        )
    }
}