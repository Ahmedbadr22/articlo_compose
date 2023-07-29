package com.ahmedbadr.articlo.app.extensions

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState


@ExperimentalFoundationApi
suspend fun PagerState.toNextPage() {
    val nextPageIndex : Int = currentPage + 1
    scrollToPage(page = nextPageIndex)
}