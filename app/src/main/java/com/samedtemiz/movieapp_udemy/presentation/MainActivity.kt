package com.samedtemiz.movieapp_udemy.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.samedtemiz.movieapp_udemy.presentation.movie_details.views.MovieDetailScreen
import com.samedtemiz.movieapp_udemy.presentation.movies.views.MovieScreen
import com.samedtemiz.movieapp_udemy.presentation.ui.theme.MovieApp_UdemyTheme
import com.samedtemiz.movieapp_udemy.util.Constants.IMDB_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApp_UdemyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.MovieScreen.route) {
                        composable(route = Screen.MovieScreen.route) {
                            MovieScreen(navController = navController)
                        }

                        composable(route = Screen.MovieDetailScreen.route+ "/{$IMDB_ID}") {
                            MovieDetailScreen()
                        }
                    }
                }
            }
        }
    }
}

