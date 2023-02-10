package com.example.bestredditposts.presentation.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bestredditposts.R
import com.example.bestredditposts.app.App
import com.example.bestredditposts.databinding.ActivityMainBinding
import com.example.bestredditposts.presentation.noInternet.InternetConnectionCheck
import com.example.bestredditposts.presentation.noInternet.NoInternetFragment
import com.example.bestredditposts.presentation.postList.PostItemFragment
import com.example.bestredditposts.presentation.splash.SplashFragment
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

        supportFragmentManager
            .beginTransaction()
            .add(binding.fragmentContainerView.id, SplashFragment())
            .commit()

        val isOnline = InternetConnectionCheck.isOnline(this)
        if(!isOnline) {
            supportFragmentManager
                .beginTransaction()
                .replace(binding.fragmentContainerView.id, NoInternetFragment())
                .commit()
        }


        val currentFragment =
            supportFragmentManager.findFragmentById(binding.fragmentContainerView.id)


        if(currentFragment != PostItemFragment() && isOnline) {
            supportFragmentManager
                .beginTransaction()
                .replace(binding.fragmentContainerView.id, PostItemFragment())
                .commit()
        }
        else {
        }


        viewModel.liveDataPost.observe(this) {
            supportFragmentManager
                .beginTransaction()
                .replace(binding.fragmentContainerView.id, PostItemFragment())
                .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btnUpdate -> {
               viewModel.getPosts()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}