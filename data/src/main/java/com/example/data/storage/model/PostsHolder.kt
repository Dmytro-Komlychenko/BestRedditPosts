package com.example.data.storage.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName



class PostsHolder (
    @SerializedName("data")
    @Expose
    var posts: Posts
)