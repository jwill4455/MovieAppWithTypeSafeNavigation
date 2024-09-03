package com.example.movieappwithtestingng.data.mapper

import com.example.movieappwithtestingng.data.dto.MovieDetailDto
import com.example.movieappwithtestingng.data.dto.MovieDto
import com.example.movieappwithtestingng.domain.model.Movie
import com.example.movieappwithtestingng.domain.model.MovieDetail
import com.example.movieappwithtestingng.util.Constants.IMAGE_BASE_URL

fun MovieDto.toDomainModel(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath.let { IMAGE_BASE_URL + it }
    )
}

fun MovieDetailDto.toDomainModel(): MovieDetail {
    return MovieDetail(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath.let { IMAGE_BASE_URL + it },
        releaseDate = releaseDate
    )
}