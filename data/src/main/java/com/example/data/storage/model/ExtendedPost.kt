package com.example.data.storage.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ExtendedPost(
    @SerializedName("data")
    @Expose
    var data: Post
    )