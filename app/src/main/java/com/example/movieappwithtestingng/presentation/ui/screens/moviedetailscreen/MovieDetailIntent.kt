package com.example.movieappwithtestingng.presentation.ui.screens.moviedetailscreen

sealed class MovieDetailIntent {
    data class LoadMovieDetail(val movieId: Int) : MovieDetailIntent()
}