package com.example.bestredditposts.di

import com.example.bestredditposts.presentation.main.MainActivity
import dagger.Component

@Component(modules = [PresentationModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)

}