package com.development.twitchtopgames.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent
    }
}