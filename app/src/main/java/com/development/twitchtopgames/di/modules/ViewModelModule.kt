package com.development.twitchtopgames.di.modules

import androidx.lifecycle.ViewModel
import com.development.twitchtopgames.di.ViewModelKey
import com.development.twitchtopgames.ui.GamesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(GamesViewModel::class)
    abstract fun bindGamesViewModel(viewModel: GamesViewModel): ViewModel
}