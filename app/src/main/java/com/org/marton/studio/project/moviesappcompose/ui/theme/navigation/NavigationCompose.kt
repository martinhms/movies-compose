package com.org.marton.studio.project.moviesappcompose.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.org.marton.studio.project.moviesappcompose.ui.theme.screens.detail.DetailScreen
import com.org.marton.studio.project.moviesappcompose.ui.theme.screens.detail.DetailViewModel
import com.org.marton.studio.project.moviesappcompose.ui.theme.screens.home.HomeScreen
import com.org.marton.studio.project.moviesappcompose.ui.theme.screens.home.HomeViewModel

@Composable
fun NavigationCompose() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onMovieClick = { movieId ->
                    navController.navigate("detail/${movieId}")
                },
                viewModel = viewModel { HomeViewModel() }
            )
        }
        composable(
            route = "detail/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        ) { backStackEntry ->
            val movieId = checkNotNull(backStackEntry.arguments?.getString("movieId"))
            DetailScreen(
                viewModel = viewModel { DetailViewModel(id = movieId) },
                onBack = { navController.popBackStack() }
            )
        }

    }
}
