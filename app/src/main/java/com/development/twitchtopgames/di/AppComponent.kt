package com.development.twitchtopgames.di

import android.app.Application
import com.development.twitchtopgames.ui.ViewModelFactory
import com.development.twitchtopgames.di.modules.*
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class,
        ViewModelModule::class,
        ContextModule::class,
        DataBaseModule::class,
        RepositoryModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun getViewModelFactory(): ViewModelFactory
}