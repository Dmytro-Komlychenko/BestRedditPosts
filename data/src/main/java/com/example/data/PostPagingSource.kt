package com.example.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.storage.retrofit.RetrofitInstance
import com.example.domain.model.Post

class PostPagingSource : PagingSource<Int, Post>() {

    private var lastPostID: String? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {

        return try {
            val pageIndex = params.key ?: 1


            val posts: ArrayList<Post> = arrayListOf()
            RetrofitInstance.api.getTopPosts(DEFAULT_COUNT_POSTS, lastPostID)
                .body()?.posts?.posts?.forEach { extendedPost ->
                posts.add(mapPostToDomain(extendedPost.data, posts.count()))
            }
            lastPostID = posts.lastOrNull()?.name
            LoadResult.Page(
                data = posts, prevKey = if (pageIndex == 1) null else pageIndex - 1,
                nextKey = pageIndex + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    private fun mapPostToDomain(dataPost: com.example.data.storage.model.Post, lastId: Int): Post {
        val id = lastId + 1

        return Post(
            id = id,
            name = dataPost.name,
            hoursAgo = dataPost.createdUNIX,
            title = dataPost.title,
            authorName = dataPost.authorName,
            thumbnail = dataPost.thumbnail,
            thumbnailWidth = dataPost.thumbnailWidth,
            thumbnailHeight = dataPost.thumbnailHeight,
            likesCount = dataPost.likesCount,
            commentsCount = dataPost.commentsCount
        )
    }

    companion object {
        const val DEFAULT_COUNT_POSTS = 25
    }

}