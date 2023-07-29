package com.ahmedbadr.articlo.data.source.local.country

import com.ahmedbadr.articlo.data.model.entities.CountryEntity
import kotlinx.coroutines.flow.Flow

interface CountryLocalDataSource {
    suspend fun addCountryToLocal(countryEntity: CountryEntity)
    suspend fun addCountriesToLocal(countries: List<CountryEntity>)
    suspend fun listCountriesFromLocal() : List<CountryEntity>
    fun listCountriesFlowFromLocal() : Flow<List<CountryEntity>>
}