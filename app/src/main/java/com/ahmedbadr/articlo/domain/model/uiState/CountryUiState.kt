package com.ahmedbadr.articlo.domain.model.uiState

import com.ahmedbadr.articlo.domain.model.data.Country


data class CountryUiState(
    val country: Country,
    var isSelected: Boolean = false
)
