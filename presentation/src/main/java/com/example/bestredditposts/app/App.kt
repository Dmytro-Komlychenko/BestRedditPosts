package com.example.bestredditposts.app

import android.app.Application
import com.example.bestredditposts.di.AppComponent
import com.example.bestredditposts.di.DaggerAppComponent
import com.example.bestredditposts.di.PresentationModule

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().presentationModule(PresentationModule(context = this)).build()
    }
}