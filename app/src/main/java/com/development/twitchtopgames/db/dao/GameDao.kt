package com.development.twitchtopgames.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.development.twitchtopgames.db.entity.GameEntity
import com.development.twitchtopgames.db.entity.TopEntity


@Dao
interface GameDao {

    @Query("SELECT * FROM ${GameEntity.TABLE_NAME}")
    fun loadAllGame(): List<GameEntity>

    @Insert(entity = GameEntity::class, onConflict = REPLACE)
    fun addGame(gameEntity: GameEntity)

    @Insert(onConflict = REPLACE)
    fun addGames(games: List<GameEntity>)

}