package com.example.movieappwithtestingng.domain.usecase

import com.example.movieappwithtestingng.domain.model.MovieDetail
import com.example.movieappwithtestingng.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int): MovieDetail {
        return repository.getMovieDetails(movieId)
    }
}