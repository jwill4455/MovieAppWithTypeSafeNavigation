package com.example.movieappwithtestingng.dependencyinjection

import com.example.movieappwithtestingng.data.repository.MovieRepositoryImpl
import com.example.movieappwithtestingng.domain.repository.MovieRepository
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
    abstract fun bindMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository
}