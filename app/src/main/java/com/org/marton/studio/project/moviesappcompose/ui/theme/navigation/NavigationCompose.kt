package com.org.marton.studio.project.moviesappcompose.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.org.marton.studio.project.moviesappcompose.R
import com.org.marton.studio.project.moviesappcompose.data.ktor.MovieService
import com.org.marton.studio.project.moviesappcompose.domain.MoviesRepository
import com.org.marton.studio.project.moviesappcompose.data.ktor.MoviesRepositoryImpl
import com.org.marton.studio.project.moviesappcompose.ui.theme.screens.detail.DetailScreen
import com.org.marton.studio.project.moviesappcompose.ui.theme.screens.detail.DetailViewModel
import com.org.marton.studio.project.moviesappcompose.ui.theme.screens.home.HomeScreen
import com.org.marton.studio.project.moviesappcompose.ui.theme.screens.home.HomeViewModel


@Composable
fun NavigationCompose() {
    val navController = rememberNavController()
    val repository = rememberMovieRepository()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onMovieClick = { movieId ->
                    navController.navigate("detail/${movieId}")
                },
                viewModel = viewModel { HomeViewModel(repository = repository) }
            )
        }
        composable(
            route = "detail/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        ) { backStackEntry ->
            val movieId = checkNotNull(backStackEntry.arguments?.getString("movieId"))
            DetailScreen(
                viewModel = viewModel { DetailViewModel(repository = repository, id = movieId) },
                onBack = { navController.popBackStack() }
            )
        }

    }
}

@Composable
private fun rememberMovieRepository(
    apiKey: String = stringResource(R.string.api_key)
): MoviesRepository = remember {
    val movieService = MovieService.create(apiKey)
    MoviesRepositoryImpl(movieService)
}
