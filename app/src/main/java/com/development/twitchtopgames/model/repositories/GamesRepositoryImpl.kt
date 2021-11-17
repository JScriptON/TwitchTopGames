package com.development.twitchtopgames.model.repositories

import com.development.twitchtopgames.model.LocalDataSource
import com.development.twitchtopgames.model.RemoteDataSource
import com.development.twitchtopgames.db.TopWithGame
import com.development.twitchtopgames.db.entity.GameEntity
import com.development.twitchtopgames.db.entity.TopEntity
import com.development.twitchtopgames.model.Top
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) :
    GamesRepository {
    override suspend fun getTopGames(limit: Int, offset: Int): List<Top> {
        val result = remoteDataSource.fetchTopList(limit, offset)
        if (result.isSuccessful) {
            if (offset == 0) {
                localDataSource.clearTops()
            }
            localDataSource.saveTops(result.tops.map {
                TopWithGame(
                    top = TopEntity(it.channels, it.viewers),
                    game = GameEntity(
                        id = it.game.id,
                        name = it.game.name,
                        logo = it.game.box.large
                    )
                )
            })
            return result.tops
        } else {
            return localDataSource.fetchTopList(limit, offset).tops
        }
    }

//    override suspend fun getTopGames(limit: Int, offset: Int): List<Top> {
//        return apiService.getTopGames(limit, offset).top
//    }
//
//    fun getLocalTop(limit: Int, offset: Int): List<Top> {
//        return emptyList()
//    }
//
//    fun addTops(top: Top) {
//        topDao.addTop(TopEntity(0, 10, 20))
//    }
}