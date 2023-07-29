package com.ahmedbadr.articlo.ui.presentation.screens.onBoarding.view

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.ahmedbadr.articlo.app.extensions.toNextPage
import com.ahmedbadr.articlo.ui.presentation.screens.onBoarding.data.onBoardingItems
import com.ahmedbadr.articlo.ui.presentation.screens.onBoarding.widgets.HorizontalPagerIndicatorBar
import com.ahmedbadr.articlo.ui.presentation.screens.onBoarding.widgets.OnBoardingItemNavigationBar
import com.ahmedbadr.articlo.ui.presentation.screens.onBoarding.widgets.OnBoardingItemPage
import com.ahmedbadr.articlo.ui.theme.ArticloTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.launch


@Composable
@ExperimentalPagerApi
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun OnBoardingScreen(
    onNavigateToLoginScreen: () -> Unit = {}
) {
    Scaffold {
        val pagerState = rememberPagerState(initialPage = 0)
        val inLastPage   = { pagerState.currentPage == onBoardingItems.size - 1}
        val resources = LocalContext.current.resources
        val coroutineScope = rememberCoroutineScope()

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4F)
            ){
                HorizontalPager(
                    pageCount = onBoardingItems.size,
                    state = pagerState,
                ) { index ->
                    OnBoardingItemPage(onBoardingItem = onBoardingItems[index])
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.0F),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                HorizontalPagerIndicatorBar(
                    pagerState,
                    onBoardingItems.size
                )
                OnBoardingItemNavigationBar(
                    resources = resources,
                    inFinalPage = inLastPage(),
                    onNextClick = {
                        coroutineScope.launch {
                            pagerState.toNextPage()
                        }
                    },
                    onSkipClick = onNavigateToLoginScreen,
                    onStartClick = onNavigateToLoginScreen
                )
            }
        }
    }
}


@Preview
@Composable
@ExperimentalPagerApi
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
fun OnBoardingScreenLightPreview() {
    ArticloTheme {
        OnBoardingScreen()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@ExperimentalPagerApi
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
fun OnBoardingScreenDarkPreview() {
    ArticloTheme {
        OnBoardingScreen()
    }
}