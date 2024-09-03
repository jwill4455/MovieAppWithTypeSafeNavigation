package com.example.movieappwithtestingng.presentation.ui.screens.movielistscreen

import com.example.movieappwithtestingng.domain.model.Movie

sealed class MovieListState {
    data object Idle : MovieListState()
    data object Loading : MovieListState()
    data class MoviesLoaded(val movies: List<Movie>) : MovieListState()
    data class Error(val message: String) : MovieListState()
}