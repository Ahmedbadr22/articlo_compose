package com.ahmedbadr.articlo.ui.presentation.screens.main.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahmedbadr.articlo.ui.presentation.screens.main.navigation.MainBottomBarScreen
import com.ahmedbadr.articlo.ui.presentation.screens.main.view.DiscoverScreen
import com.ahmedbadr.articlo.ui.presentation.screens.main.view.HomeScreen
import com.ahmedbadr.articlo.ui.presentation.screens.main.view.MyArticlesScreen
import com.ahmedbadr.articlo.ui.presentation.screens.main.view.ProfileScreen
import com.ahmedbadr.articlo.ui.presentation.screens.main.viewModel.MainViewModel
import org.koin.androidx.compose.koinViewModel


@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun MainBottomNavigationHost(
    paddingValues: PaddingValues,
    navController: NavHostController
) {
    val mainViewModel: MainViewModel  = koinViewModel()

    NavHost(
        navController = navController,
        startDestination = MainBottomBarScreen.Home.route
    ) {
        composable(route = MainBottomBarScreen.Home.route) {
            HomeScreen(
                paddingValues = paddingValues,
                userFullNameFlow = mainViewModel.userFullNameFlow
            )
        }

        composable(route = MainBottomBarScreen.Discover.route) {
            DiscoverScreen()
        }

        composable(route = MainBottomBarScreen.MyArticles.route) {
            MyArticlesScreen()
        }

        composable(route = MainBottomBarScreen.Profile.route) {
            ProfileScreen()
        }
    }
}