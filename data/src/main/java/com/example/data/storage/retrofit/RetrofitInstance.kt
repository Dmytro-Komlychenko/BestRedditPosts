package com.example.data.storage.retrofit

import com.example.data.storage.retrofit.api.PostApi
import com.example.data.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.REDDIT_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: PostApi by lazy {
        retrofit.create(PostApi::class.java)
    }

}