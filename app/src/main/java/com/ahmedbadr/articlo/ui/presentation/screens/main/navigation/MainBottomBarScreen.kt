package com.ahmedbadr.articlo.ui.presentation.screens.main.navigation

import com.ahmedbadr.articlo.R

sealed class MainBottomBarScreen(
    val route: String,
    val title: Int,
    val iconRes:  Int,
) {
    object Home : MainBottomBarScreen(
        route = "home",
        title = R.string.home,
        iconRes = R.drawable.home
    )

    object Profile : MainBottomBarScreen(
        route = "profile",
        title = R.string.profile,
        iconRes = R.drawable.user_rounded
    )

    object Discover : MainBottomBarScreen(
        route = "discover",
        title = R.string.discover,
        iconRes = R.drawable.compass_square
    )

    object MyArticles : MainBottomBarScreen(
        route = "my_articles",
        title = R.string.my_articles,
        iconRes = R.drawable.file_text
    )
}
