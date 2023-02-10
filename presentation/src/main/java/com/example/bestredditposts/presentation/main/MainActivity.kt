package com.example.bestredditposts.presentation.main

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bestredditposts.presentation.noInternet.NoInternetFragment
import com.example.bestredditposts.app.App
import com.example.bestredditposts.databinding.ActivityMainBinding
import com.example.bestredditposts.presentation.noInternet.InternetConnectionCheck
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]
        if(!InternetConnectionCheck.isOnline(this)) {
            this.supportFragmentManager
                .beginTransaction()
                .replace(binding.fragmentContainerView.id, NoInternetFragment())
                .commit()
        }
    }


}