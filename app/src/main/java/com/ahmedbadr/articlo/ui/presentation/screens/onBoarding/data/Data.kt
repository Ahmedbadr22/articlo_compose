package com.ahmedbadr.articlo.ui.presentation.screens.onBoarding.data

import com.ahmedbadr.articlo.R
import com.ahmedbadr.articlo.ui.presentation.screens.onBoarding.uiState.OnBoardingItem

val onBoardingItems : List<OnBoardingItem> = listOf(
    OnBoardingItem(
        R.drawable.read,
        R.string.on_boarding_0_title,
        R.string.on_boarding_0_subtitle,
    ),
    OnBoardingItem(
        R.drawable.create,
        R.string.on_boarding_1_title,
        R.string.on_boarding_1_subtitle,
    ),
    OnBoardingItem(
        R.drawable.connect,
        R.string.on_boarding_2_title,
        R.string.on_boarding_2_subtitle,
    ),
)