package com.development.twitchtopgames

import android.app.Application
import android.content.Context
import com.development.twitchtopgames.di.AppComponent
import com.development.twitchtopgames.di.DaggerAppComponent

class TwitchGamesApplication : Application() {

    lateinit var component: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        createComponent()
    }

    private fun createComponent() {
        component = DaggerAppComponent.create()
    }
}

val Context.component: AppComponent
    get() = when (this) {
        is TwitchGamesApplication -> component
        else -> this.applicationContext.component
    }