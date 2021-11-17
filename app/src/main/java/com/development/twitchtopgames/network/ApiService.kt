package com.development.twitchtopgames.network

import com.development.twitchtopgames.model.Item
import com.development.twitchtopgames.model.Top
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("games/top")
    suspend fun getTopGames(@Query("limit") limit: Int, @Query("offset") offset: Int): Response<Item>
}