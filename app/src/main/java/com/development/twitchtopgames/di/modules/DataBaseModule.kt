package com.development.twitchtopgames.di.modules

import android.content.Context
import androidx.room.Room
import com.development.twitchtopgames.db.TwitchDataBase
import com.development.twitchtopgames.db.dao.GameDao
import com.development.twitchtopgames.db.dao.TopDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideDataBase(context: Context): TwitchDataBase {
        return Room.databaseBuilder(
            context,
            TwitchDataBase::class.java,
            TwitchDataBase.DB_NAME
        ).allowMainThreadQueries().build()
    }

    @Provides
    fun provideTopDao(twitchDataBase: TwitchDataBase): TopDao {
        return twitchDataBase.topDao()
    }

    @Provides
    fun provideGameDao(twitchDataBase: TwitchDataBase): GameDao {
        return twitchDataBase.gameDao()
    }
}