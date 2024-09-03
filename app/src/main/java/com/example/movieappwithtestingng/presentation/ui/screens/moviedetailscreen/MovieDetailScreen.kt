package com.example.movieappwithtestingng.presentation.ui.screens.moviedetailscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter

@Composable
fun MovieDetailScreen(
    movieId: Int,
    viewModel: MovieDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    LaunchedEffect(movieId) {
        viewModel.handleIntent(MovieDetailIntent.LoadMovieDetail(movieId))
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is MovieDetailState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            is MovieDetailState.MovieLoaded -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = state.movieDetail.posterPath),
                        contentDescription = state.movieDetail.title,
                        modifier = Modifier
                            .fillMaxSize(0.5f)
                            .clip(RectangleShape)
                            .align(Alignment.CenterHorizontally)
                    )

                    Text(
                        text = state.movieDetail.title,
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(bottom = 8.dp),
                        color = Color.White

                    )
                    Text(
                        text = state.movieDetail.overview,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 8.dp),
                        color = Color.White
                    )
                    Text(
                        text = "Release Date: ${state.movieDetail.releaseDate}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 8.dp),
                        color = Color.White
                    )
                }
            }

            is MovieDetailState.Error -> {
                Text(
                    text = state.message,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .align(Alignment.Center)
                )
            }

            else -> {}
        }
    }
}
