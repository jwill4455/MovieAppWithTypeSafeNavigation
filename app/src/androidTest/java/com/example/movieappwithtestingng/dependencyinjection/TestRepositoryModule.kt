package com.example.movieappwithtestingng.dependencyinjection

import com.example.movieappwithtestingng.data.repository.FakeMovieRepositoryImpl
import com.example.movieappwithtestingng.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RepositoryModule::class]
)
object TestRepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(): MovieRepository {
        return FakeMovieRepositoryImpl()
    }

}