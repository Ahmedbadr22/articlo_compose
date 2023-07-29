package com.ahmedbadr.articlo.ui.presentation.screens.main.view

import android.annotation.SuppressLint

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ahmedbadr.articlo.ui.presentation.screens.main.navigation.MainBottomNavigationHost
import kotlinx.coroutines.flow.Flow



@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalFoundationApi::class
)
@Composable
fun MainScreen(
    onNavigateToLoginScreen: () -> Unit = {},
    isAuthenticatedFlow: Flow<Boolean>,
) {

    val navController: NavHostController = rememberNavController()

    LaunchedEffect(isAuthenticatedFlow) {
        isAuthenticatedFlow.collect { isAuthenticated ->
            if (!isAuthenticated) {
                onNavigateToLoginScreen()
            }
        }
    }

    Scaffold(
        bottomBar = {
            BottomNavBar(navHostController = navController)
        }
    ) { paddingValues ->
        MainBottomNavigationHost(
            paddingValues = paddingValues,
            navController = navController
        )
    }
}



