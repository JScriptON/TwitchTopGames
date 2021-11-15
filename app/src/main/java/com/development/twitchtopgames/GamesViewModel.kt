package com.development.twitchtopgames

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.development.twitchtopgames.model.Top
import kotlinx.coroutines.launch

class GamesViewModel : ViewModel() {

    private val gamesLiveData = MutableLiveData<List<Top>>()


    fun loadTopGames() {
        viewModelScope.launch {
        }
    }
}