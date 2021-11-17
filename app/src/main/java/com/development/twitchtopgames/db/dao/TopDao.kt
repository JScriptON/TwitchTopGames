package com.development.twitchtopgames.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import com.development.twitchtopgames.db.TopWithGame
import com.development.twitchtopgames.db.entity.GameEntity
import com.development.twitchtopgames.db.entity.TopEntity

@Dao
interface TopDao {

    @Query("SELECT * FROM ${TopEntity.TABLE_NAME}")
    fun loadTops(): List<TopEntity>

    @Query("DELETE FROM ${TopEntity.TABLE_NAME}")
    fun clearTops()

//    @Transaction
//    @Query("SELECT * FROM ${TopEntity.TABLE_NAME} ")
//    fun loadTopsWithGame(): List<TopWithGame>

    @Transaction
//    @Query(
//        "SELECT * FROM ${GameEntity.TABLE_NAME}, ${TopEntity.TABLE_NAME} WHERE " +
//                "${GameEntity.TABLE_NAME}.id = ${TopEntity.TABLE_NAME}.game_id  "
//    )
    @Query(
        "SELECT  * FROM ${TopEntity.TABLE_NAME} LIMIT :limit OFFSET :offset"
    )
    fun loadTopsWithGame(limit: Int, offset: Int): List<TopWithGame>


//    @Insert
//    fun insertTops(tops: List<TopWithGame>)


    @Insert(entity = TopEntity::class, onConflict = REPLACE)
    fun addTop(topEntity: TopEntity): Long

    @Insert(onConflict = REPLACE)
    fun addTops(tops: List<TopEntity>)

}