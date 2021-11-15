package com.development.twitchtopgames.di.modules

import com.development.twitchtopgames.ApiService
import com.development.twitchtopgames.ServiceInterceptor
import com.development.twitchtopgames.model.repositories.GamesRepository
import com.development.twitchtopgames.model.repositories.GamesRepositoryImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    private val BASE_URL = "https://api.twitch.tv/kraken/"
    private val CLIENT_ID = "ahuoi1tl0qmqbyi8jo8nitbmuaad7w"

    @Singleton
    @Provides
    fun provideApiRepository(apiService: ApiService): GamesRepository {
        return GamesRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(ServiceInterceptor(CLIENT_ID)).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


}