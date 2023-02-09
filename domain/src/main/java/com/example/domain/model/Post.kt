package com.example.domain.model

data class Post(
    val id: Int,
    var approvedAtUtc: Int,
    var authorFullname: String,
    var thumbnail: String?,
    var commentsCount: Int,
)