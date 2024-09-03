package com.example.movieappwithtestingng.presentation.ui.screens.movielistscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.movieappwithtestingng.presentation.ui.components.MovieItem
import com.example.movieappwithtestingng.presentation.ui.components.MovieSearchBar

@Composable
fun MovieListScreen(
    onNavigateToDetail: (Int) -> Unit,
    viewModel: MovieListViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value
    val suggestions = viewModel.suggestions.collectAsStateWithLifecycle().value

    LaunchedEffect(Unit) {
        viewModel.handleIntent(MovieListIntent.LoadTopRatedMovies)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column {
            MovieSearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp),
                hint = "Search Movies...",
                onSearch = {
                    viewModel.handleIntent(MovieListIntent.SearchMovies(it))
                }
            )

            if (suggestions.isNotEmpty()) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(suggestions) { movie ->
                        MovieItem(movie = movie, onClick = { onNavigateToDetail(movie.id) })
                        HorizontalDivider()
                    }
                }
            } else {
                when (state) {
                    is MovieListState.Loading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }

                    is MovieListState.MoviesLoaded -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(16.dp)
                        ) {
                            items(state.movies) { movie ->
                                MovieItem(movie = movie, onClick = { onNavigateToDetail(movie.id) })
                                HorizontalDivider()
                            }
                        }
                    }

                    is MovieListState.Error -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = state.message,
                                color = MaterialTheme.colorScheme.error,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )
                        }
                    }

                    else -> {}
                }
            }
        }
    }
}


