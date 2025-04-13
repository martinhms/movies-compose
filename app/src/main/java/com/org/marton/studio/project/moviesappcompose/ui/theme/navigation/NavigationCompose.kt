package com.org.marton.studio.project.moviesappcompose.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.org.marton.studio.project.moviesappcompose.R
import com.org.marton.studio.project.moviesappcompose.data.MovieService
import com.org.marton.studio.project.moviesappcompose.data.MoviesRepository
import com.org.marton.studio.project.moviesappcompose.ui.theme.screens.detail.DetailScreen
import com.org.marton.studio.project.moviesappcompose.ui.theme.screens.detail.DetailViewModel
import com.org.marton.studio.project.moviesappcompose.ui.theme.screens.home.HomeScreen
import com.org.marton.studio.project.moviesappcompose.ui.theme.screens.home.HomeViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


@Composable
fun NavigationCompose(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val repository = rememberMovieRepository()
    // pasamos las funcionaes a remember para que no se creen cada vez que recomposen

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
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys =
                    true // si no se parsea el objeto completo lanza un error en false,
                coerceInputValues = true
            })
        }
        install(DefaultRequest) {
            url {
                protocol = URLProtocol.HTTPS
                host = "api.themoviedb.org"
                parameters.append("api_key", apiKey)
            }
        }
    }

    MoviesRepository(MovieService(client = client))
}
