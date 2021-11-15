package com.development.twitchtopgames.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.development.twitchtopgames.util.Settings
import com.development.twitchtopgames.model.Top
import com.development.twitchtopgames.model.repositories.GamesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class GamesViewModel @Inject constructor(private var gamesRepository: GamesRepository) :
    ViewModel() {

    private val gamesLiveData = MutableLiveData<List<Top>>()
    private var offset = 0

    init {
        loadTopGames()
    }

    fun loadTopGames() {
        viewModelScope.launch {
            val games = gamesRepository.getTopGames(Settings.LIMIT, offset)
            offset += Settings.LIMIT
            gamesLiveData.postValue(games)
        }
    }

    fun getGames(): LiveData<List<Top>> {
        return gamesLiveData
    }


}