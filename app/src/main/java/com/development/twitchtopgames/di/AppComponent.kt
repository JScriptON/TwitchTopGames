package com.development.twitchtopgames.di

import com.development.twitchtopgames.ViewModelFactory
import com.development.twitchtopgames.di.modules.NetworkModule
import com.development.twitchtopgames.di.modules.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent
    }

    fun getViewModelFactory(): ViewModelFactory
}