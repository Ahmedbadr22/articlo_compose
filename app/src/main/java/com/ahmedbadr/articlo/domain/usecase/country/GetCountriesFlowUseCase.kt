package com.ahmedbadr.articlo.domain.usecase.country

import androidx.compose.runtime.collectAsState
import com.ahmedbadr.articlo.data.mappers.toCountry
import com.ahmedbadr.articlo.data.model.entities.CountryEntity
import com.ahmedbadr.articlo.domain.model.data.Country
import com.ahmedbadr.articlo.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform

class GetCountriesFlowUseCase(
    private val countryRepository: CountryRepository
) {
    operator fun invoke() : Flow<List<Country>> {
        return countryRepository.getCountriesFlow().map { countriesEntity ->
            countriesEntity.map(CountryEntity::toCountry)
        }
    }
}