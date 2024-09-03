package com.example.movieappwithtestingng.data.source.remote

import com.example.movieappwithtestingng.data.dto.MovieDetailDto
import com.example.movieappwithtestingng.data.dto.MovieResponseDto
import com.example.movieappwithtestingng.data.dto.MovieSearchResponseDto
import com.example.movieappwithtestingng.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = API_KEY
    ): MovieResponseDto

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): MovieDetailDto

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("api_key") apiKey: String = API_KEY
    ): MovieSearchResponseDto
}