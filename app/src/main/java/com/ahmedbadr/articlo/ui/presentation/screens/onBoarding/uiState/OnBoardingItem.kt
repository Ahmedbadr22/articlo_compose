package com.ahmedbadr.articlo.ui.presentation.screens.onBoarding.uiState

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnBoardingItem(
    @DrawableRes val imageRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val captionRes: Int,
)
