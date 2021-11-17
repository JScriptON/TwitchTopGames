package com.development.twitchtopgames.db

import androidx.room.RoomDatabase
import androidx.room.Database
import com.development.twitchtopgames.db.dao.GameDao
import com.development.twitchtopgames.db.dao.TopDao
import com.development.twitchtopgames.db.entity.GameEntity
import com.development.twitchtopgames.db.entity.TopEntity

@Database(
    entities = [
        TopEntity::class,
        GameEntity::class
    ], version = TwitchDataBase.DB_VERSION, exportSchema = false
)
abstract class TwitchDataBase : RoomDatabase() {

    abstract fun topDao(): TopDao
    abstract fun gameDao(): GameDao


    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "twitch_db"
    }
}