package com.development.twitchtopgames

import com.development.twitchtopgames.model.Top
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/games/top")
    fun getTopGames(@Query("limit") limit: Int, @Query("offset") offset: Int): List<Top>
}