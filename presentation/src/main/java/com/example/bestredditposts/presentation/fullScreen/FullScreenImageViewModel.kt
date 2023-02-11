package com.example.bestredditposts.presentation.fullScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FullScreenImageViewModel: ViewModel() {
    var imageLink: MutableLiveData<String> = MutableLiveData()
}