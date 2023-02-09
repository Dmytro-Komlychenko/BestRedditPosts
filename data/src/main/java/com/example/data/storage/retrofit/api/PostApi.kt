package com.example.data.storage.retrofit.api

import com.example.data.storage.model.PostsHolder
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {
    @GET("top.json")
    suspend fun getTopPosts(): Response<PostsHolder>
}