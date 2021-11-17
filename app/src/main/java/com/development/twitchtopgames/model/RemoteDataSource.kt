package com.development.twitchtopgames.model

import com.development.twitchtopgames.network.ApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) : DataSource {
    override suspend fun fetchTopList(limit: Int, offset: Int): GamesResult {
        val result = apiService.getTopGames(limit, offset)
        return if (result.isSuccessful && result.body() != null) {
            GamesResult(result.body()!!.top, true, error = null)
        } else {
            GamesResult(emptyList(), false, error = result.code().toString())
        }
    }
}