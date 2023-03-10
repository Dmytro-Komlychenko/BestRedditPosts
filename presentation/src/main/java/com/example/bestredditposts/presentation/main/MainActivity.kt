package com.example.bestredditposts.presentation.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bestredditposts.R
import com.example.bestredditposts.app.App
import com.example.bestredditposts.databinding.ActivityMainBinding
import com.example.bestredditposts.presentation.noInternet.InternetConnectionCheck
import com.example.bestredditposts.presentation.noInternet.NoInternetFragment
import com.example.bestredditposts.presentation.postList.PostsFragment
import com.example.bestredditposts.presentation.postList.PostsViewModel
import com.example.bestredditposts.presentation.postList.PostsViewModelFactory
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PostsViewModel

    @Inject
    lateinit var postsViewModelFactory: PostsViewModelFactory

    private val isOnline get() = InternetConnectionCheck.isOnline(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, postsViewModelFactory)[PostsViewModel::class.java]

        showFragmentDependingOnInternet()
    }

    private fun showFragmentDependingOnInternet() {
        if (!isOnline && viewModel.posts.value == null) replaceFragment(NoInternetFragment())
        else replaceFragment(PostsFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainerView.id, fragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btnUpdate -> {
                if (!isOnline) {
                    Snackbar.make(
                        binding.fragmentContainerView,
                        resources.getString(R.string.no_internet),
                        Snackbar.LENGTH_SHORT or Snackbar.LENGTH_INDEFINITE
                    ).show()
                } else {
                    viewModel.updatePosts.value = true
                    showFragmentDependingOnInternet()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

}