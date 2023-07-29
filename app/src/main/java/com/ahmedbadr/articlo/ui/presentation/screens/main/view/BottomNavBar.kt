package com.ahmedbadr.articlo.ui.presentation.screens.main.view

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ahmedbadr.articlo.ui.presentation.screens.main.navigation.MainBottomBarScreen


@Composable
fun BottomNavBar(
    navHostController: NavHostController
) {

    val screens: List<MainBottomBarScreen> = listOf(
        MainBottomBarScreen.Home,
        MainBottomBarScreen.Discover,
        MainBottomBarScreen.MyArticles,
        MainBottomBarScreen.Profile,
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = Color.Transparent
    ) {
        screens.forEach { screen ->
            AddBottomNavBarItem(
                screen = screen,
                currentDestination = currentDestination,
                navHostController = navHostController
            )
        }
    }
}

@Composable
fun RowScope.AddBottomNavBarItem(
    screen: MainBottomBarScreen,
    navHostController: NavHostController,
    currentDestination: NavDestination?,
) {
    val resources = LocalContext.current.resources
    NavigationBarItem(
        label = {
            Text(text = resources.getString(screen.title))
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.iconRes),
                contentDescription = resources.getString(screen.title)
            )
        },
        selected = currentDestination?.hierarchy?.any { navDestination ->
            navDestination.route == screen.route
        } ==  true,
        onClick = {
            navHostController.navigate(screen.route)
        }
    )
}

