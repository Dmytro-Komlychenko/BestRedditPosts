package com.example.domain.model

data class Post(
    val id: Int,
    val name: String,
    var hoursAgo: Long,
    var authorName: String,
    var title: String,
    var thumbnail: String?,
    var thumbnailWidth: Int?,
    var thumbnailHeight: Int?,
    var likesCount: Int,
    var commentsCount: Int,
)