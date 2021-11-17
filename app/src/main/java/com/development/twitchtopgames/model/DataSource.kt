package com.development.twitchtopgames.model

import com.development.twitchtopgames.model.GamesResult

interface DataSource {

    suspend fun fetchTopList(limit: Int, offset: Int): GamesResult//List<Top>
}