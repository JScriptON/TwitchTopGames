package com.development.twitchtopgames.di.modules

import com.development.twitchtopgames.network.ApiService
import com.development.twitchtopgames.model.LocalDataSource
import com.development.twitchtopgames.model.RemoteDataSource
import com.development.twitchtopgames.db.dao.GameDao
import com.development.twitchtopgames.db.dao.TopDao
import com.development.twitchtopgames.model.repositories.GamesRepository
import com.development.twitchtopgames.model.repositories.GamesRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @[Singleton Provides]
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource {
        return RemoteDataSource(apiService)
    }

    @[Singleton Provides]
    fun provideLocalDataSource(topDao: TopDao, gameDao: GameDao): LocalDataSource {
        return LocalDataSource(topDao, gameDao)
    }

    @[Singleton Provides]
    fun provideApiRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): GamesRepository {
        return GamesRepositoryImpl(remoteDataSource, localDataSource)
    }
}