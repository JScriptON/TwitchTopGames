package com.development.twitchtopgames.model.repositories

import com.development.twitchtopgames.model.Item
import com.development.twitchtopgames.model.Top
import javax.inject.Inject

interface GamesRepository {
    suspend fun getTopGames(limit: Int, offset: Int): List<Top>
}