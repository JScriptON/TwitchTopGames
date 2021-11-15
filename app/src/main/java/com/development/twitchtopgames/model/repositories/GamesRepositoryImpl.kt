package com.development.twitchtopgames.model.repositories

import com.development.twitchtopgames.ApiService
import com.development.twitchtopgames.model.Item
import com.development.twitchtopgames.model.Top
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    GamesRepository {

    override suspend fun getTopGames(limit: Int, offset: Int): List<Top> {
        val res = apiService.getTopGames(limit, offset).top
        return res
    }
}