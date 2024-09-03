package com.example.movieappwithtestingng.domain.usecase

import com.example.movieappwithtestingng.domain.model.Movie
import com.example.movieappwithtestingng.domain.repository.MovieRepository
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(query: String): List<Movie> {
        return repository.searchMovies(query)
    }
}