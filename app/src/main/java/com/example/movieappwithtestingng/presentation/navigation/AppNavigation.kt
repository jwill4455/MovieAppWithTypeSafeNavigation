package com.example.movieappwithtestingng.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.movieappwithtestingng.presentation.ui.screens.moviedetailscreen.MovieDetailScreen
import com.example.movieappwithtestingng.presentation.ui.screens.movielistscreen.MovieListScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            MovieListScreen(onNavigateToDetail = { movieId ->
                navController.navigate(MovieDetail(movieId))
            })
        }
        composable<MovieDetail> { backStackEntry ->
            val movieDetailArgs: MovieDetail = backStackEntry.toRoute()
            MovieDetailScreen(movieDetailArgs.id)
        }
    }
}