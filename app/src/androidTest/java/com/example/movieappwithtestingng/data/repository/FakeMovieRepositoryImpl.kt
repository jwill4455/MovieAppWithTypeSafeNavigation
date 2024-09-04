package com.example.movieappwithtestingng.data.repository

import com.example.movieappwithtestingng.domain.model.Movie
import com.example.movieappwithtestingng.domain.model.MovieDetail
import com.example.movieappwithtestingng.domain.repository.MovieRepository

class FakeMovieRepositoryImpl : MovieRepository {

    override suspend fun getTopRatedMovies(): List<Movie> {
        return listOf(
            Movie(
                id = 1, title = "The Shawshank Redemption",
                overview = "Great movie", posterPath = "/path.jpg"
            ),
            Movie(
                id = 2, title = "The Godfather",
                overview = "Classic movie", posterPath = "/path2.jpg"
            )
        )
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetail {
        return MovieDetail(
            id = movieId, title = "The Shawshank Redemption",
            overview = "Great movie", posterPath = "/path.jpg", releaseDate = "1994-09-23"
        )
    }

    override suspend fun searchMovies(query: String): List<Movie> {
        return listOf(
            Movie(
                id = 1,
                title = "The Shawshank Redemption",
                overview = "Great movie",
                posterPath = "/path.jpg"
            )
        )
    }
}