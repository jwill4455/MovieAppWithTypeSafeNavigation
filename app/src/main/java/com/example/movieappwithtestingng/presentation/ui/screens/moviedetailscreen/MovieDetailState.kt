package com.example.movieappwithtestingng.presentation.ui.screens.moviedetailscreen

import com.example.movieappwithtestingng.domain.model.MovieDetail

sealed class MovieDetailState {
    data object Idle : MovieDetailState()
    data object Loading : MovieDetailState()
    data class MovieLoaded(val movieDetail: MovieDetail) : MovieDetailState()
    data class Error(val message: String) : MovieDetailState()
}