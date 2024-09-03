package com.example.movieappwithtestingng

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.movieappwithtestingng.presentation.navigation.AppNavigation
import com.example.movieappwithtestingng.ui.theme.MovieAppWithTestingNGTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieAppWithTestingNGTheme {
                AppNavigation()
            }
        }
    }
}