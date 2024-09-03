package com.example.movieappwithtestingng.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class MovieDetail(val id: Int)
