package com.example.movieappwithtestingng.presentation.ui.screens.moviedetailscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappwithtestingng.domain.usecase.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<MovieDetailState>(MovieDetailState.Idle)
    val state: StateFlow<MovieDetailState> get() = _state

    fun handleIntent(intent: MovieDetailIntent) {
        when (intent) {
            is MovieDetailIntent.LoadMovieDetail -> loadMovieDetail(intent.movieId)
        }
    }

    private fun loadMovieDetail(movieId: Int) {
        viewModelScope.launch {
            _state.value = MovieDetailState.Loading
            try {
                val movieDetail = getMovieDetailsUseCase(movieId)
                _state.value = MovieDetailState.MovieLoaded(movieDetail)
            } catch (e: Exception) {
                _state.value = MovieDetailState.Error(e.message ?: "Unknown Error")
            }
        }
    }
}