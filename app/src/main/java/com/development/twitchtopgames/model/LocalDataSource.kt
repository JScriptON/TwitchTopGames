package com.development.twitchtopgames.model

import com.development.twitchtopgames.util.Mapper
import com.development.twitchtopgames.db.TopWithGame
import com.development.twitchtopgames.db.dao.GameDao
import com.development.twitchtopgames.db.dao.TopDao
import java.lang.Exception
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val topDao: TopDao,
    private val gameDao: GameDao
) : DataSource {
    override suspend fun fetchTopList(limit: Int, offset: Int): GamesResult {
        return try {
            val data = topDao.loadTopsWithGame(limit, offset)
            return GamesResult(data.map { Mapper.toModel(it) }.toList(), true, error = null)
        } catch (ex: Exception) {
            GamesResult(emptyList(), false, error = ex.message)
        }
    }

    fun clearTops() {
        topDao.clearTops()
    }

    fun saveTops(tops: List<TopWithGame>) {
        tops.forEach {
            val id = topDao.addTop(it.top)
            gameDao.addGame(it.game.let { game -> game!!.copy(topId = id.toInt()) })
        }
    }

}