package com.example.movieappwithtestingng.presentation.ui.screens.movielistscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappwithtestingng.domain.model.Movie
import com.example.movieappwithtestingng.domain.usecase.GetTopRatedMoviesUseCase
import com.example.movieappwithtestingng.domain.usecase.SearchMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val searchMoviesUseCase: SearchMoviesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<MovieListState>(MovieListState.Idle)
    val state: StateFlow<MovieListState> get() = _state

    private val _suggestions = MutableStateFlow<List<Movie>>(emptyList())
    val suggestions: StateFlow<List<Movie>> get() = _suggestions

    fun handleIntent(intent: MovieListIntent) {
        when (intent) {
            is MovieListIntent.LoadTopRatedMovies -> loadTopRatedMovies()
            is MovieListIntent.SearchMovies -> searchMovies(intent.query)
        }
    }

    private fun loadTopRatedMovies() {
        viewModelScope.launch {
            _state.value = MovieListState.Loading
            try {
                val movies = getTopRatedMoviesUseCase()
                _state.value = MovieListState.MoviesLoaded(movies)
            } catch (e: Exception) {
                _state.value = MovieListState.Error(e.message ?: "Unknown Error")
            }
        }
    }

    private fun searchMovies(query: String) {
        viewModelScope.launch {
            if (query.isEmpty()) {
                _suggestions.value = emptyList()
                loadTopRatedMovies()
            } else {
                try {
                    val movies = searchMoviesUseCase(query)
                    _suggestions.value = movies
                    _state.value = MovieListState.MoviesLoaded(movies)
                } catch (e: Exception) {
                    _state.value = MovieListState.Error(e.message ?: "Unknown Error")
                    _suggestions.value = emptyList()
                }
            }
        }
    }
}
