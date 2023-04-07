package com.example.classapp.di

import com.example.classapp.data.repository.PokeRepository
import com.example.classapp.data.repository.PokeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindPokeRepository(
        PokeRepositoryImpl: PokeRepositoryImpl,
    ): PokeRepository
}