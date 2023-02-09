package com.example.domain.model

data class Post(
    var approvedAtUtc: Int,
    var authorFullname: String,
    var thumbnail: String?,
    var commentsCount: Int,
)