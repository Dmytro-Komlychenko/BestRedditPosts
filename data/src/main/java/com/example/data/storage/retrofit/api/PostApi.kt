package com.example.data.storage.retrofit.api

import com.example.data.storage.model.PostsHolder
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApi {
    @GET("top.json")
    suspend fun getTopPosts(
        @Query("limit") limit: Int,
        @Query("after") lastPostID: String?
    ): Response<PostsHolder>
}