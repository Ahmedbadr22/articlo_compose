package com.ahmedbadr.articlo.data.mappers

import com.ahmedbadr.articlo.data.model.entities.CountryEntity
import com.ahmedbadr.articlo.data.model.response.CountryResponse
import com.ahmedbadr.articlo.domain.model.data.Country
import com.ahmedbadr.articlo.domain.model.uiState.CountryUiState


fun CountryEntity.toCountry() = Country(id, name, abbreviation, flagPath)
fun CountryEntity.toCountryUiState() = CountryUiState(Country(id, name, abbreviation, flagPath))
fun CountryResponse.toCountryEntity() = CountryEntity(id, name, abbreviation, flagPath)
