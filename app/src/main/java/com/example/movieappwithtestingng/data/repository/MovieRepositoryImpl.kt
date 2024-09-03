package com.example.movieappwithtestingng.data.repository

import com.example.movieappwithtestingng.data.mapper.toDomainModel
import com.example.movieappwithtestingng.data.source.remote.MovieApiService
import com.example.movieappwithtestingng.domain.model.Movie
import com.example.movieappwithtestingng.domain.model.MovieDetail
import com.example.movieappwithtestingng.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: MovieApiService
) : MovieRepository {

    override suspend fun getTopRatedMovies(): List<Movie> {
        return apiService.getTopRatedMovies().results.map { it.toDomainModel() }
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetail {
        return apiService.getMovieDetails(movieId).toDomainModel()
    }

    override suspend fun searchMovies(query: String): List<Movie> {
        return apiService.searchMovies(query).results.map { it.toDomainModel() }
    }
}