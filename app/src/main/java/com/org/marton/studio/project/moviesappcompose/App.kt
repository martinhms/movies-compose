package com.org.marton.studio.project.moviesappcompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.org.marton.studio.project.moviesappcompose.ui.theme.screens.detail.DetailScreen
import com.org.marton.studio.project.moviesappcompose.ui.theme.screens.home.HomeScreen

@Composable
@Preview
fun App(modifier: Modifier = Modifier) {
    NavigationCompose()
}

@Composable
fun NavigationCompose(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onMovieClick = { movieId ->
                    navController.navigate("detail/${movieId}")
                },
            )
        }
        composable(
            route = "detail/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")
            DetailScreen(
                movie = movieId ?: "",
                onBack = { navController.popBackStack() }
            )
        }

    }
}

