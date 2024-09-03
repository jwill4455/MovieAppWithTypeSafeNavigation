package com.example.movieappwithtestingng.domain.repository

import com.example.movieappwithtestingng.domain.model.Movie
import com.example.movieappwithtestingng.domain.model.MovieDetail

interface MovieRepository {
    suspend fun getTopRatedMovies(): List<Movie>
    suspend fun getMovieDetails(movieId: Int): MovieDetail
    suspend fun searchMovies(query: String): List<Movie>
}