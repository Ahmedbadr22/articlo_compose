package com.ahmedbadr.articlo.ui.presentation.screens.onBoarding.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun HorizontalPagerIndicatorBar(
    pagerState: PagerState,
    pageCount: Int
) {
    HorizontalPagerIndicator(
        pagerState = pagerState,
        pageCount = pageCount,
        indicatorShape = CircleShape,
        activeColor = MaterialTheme.colorScheme.onBackground,
        indicatorWidth = 13.dp,
        indicatorHeight = 13.dp
    )
}