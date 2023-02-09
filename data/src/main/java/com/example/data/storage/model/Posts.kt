package com.example.data.storage.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName



class Posts (
    @SerializedName("children")
    @Expose
    var posts: List<ExtendedPost>
)