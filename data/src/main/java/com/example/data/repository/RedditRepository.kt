package com.example.data.repository

import com.example.data.storage.retrofit.RetrofitInstance
import com.example.domain.model.Post

class RedditRepository : com.example.domain.repositoryI.RedditRepository {

    val posts: ArrayList<Post?> = arrayListOf()

    override suspend fun getTopPosts(): ArrayList<Post?> {

        RetrofitInstance.api.getTopPosts().body()?.posts?.posts?.forEach { extendedPost ->
            posts.add(mapPostToDomain(extendedPost.data))
        }
        return posts
    }

    private fun mapPostToDomain(dataPost: com.example.data.storage.model.Post): Post {
        val id = if(posts.isEmpty()) 1 else posts.last()?.id?.plus(1) ?: 1

        return Post(
            id = id,
            approvedAtUtc = dataPost.approvedAtUtc,
            authorFullname = dataPost.authorFullname,
            thumbnail = dataPost.thumbnail,
            commentsCount = dataPost.commentsCount
        )
    }
}