package com.development.twitchtopgames

import android.app.Application
import com.development.twitchtopgames.di.AppComponent

class TwitchGamesApplication : Application() {

    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        createComponent()
    }

    private fun createComponent() {
        component = DaggerAppComponent.create()
    }
}