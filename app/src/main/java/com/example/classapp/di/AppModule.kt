package com.example.classapp.di

import com.example.classapp.data.PokeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesPokeApi(): PokeApi =
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
}