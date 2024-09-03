package com.example.movieappwithtestingng.presentation.ui.screens.movielistscreen


sealed class MovieListIntent {
    data object LoadTopRatedMovies : MovieListIntent()
    data class SearchMovies(val query: String) : MovieListIntent()
}