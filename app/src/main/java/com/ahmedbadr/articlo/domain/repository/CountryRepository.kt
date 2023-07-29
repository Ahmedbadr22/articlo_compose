package com.ahmedbadr.articlo.domain.repository

import com.ahmedbadr.articlo.data.model.entities.CountryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface CountryRepository {

    suspend fun listCountriesFromRemoteThenInsertInLocal()
    fun getCountriesFlow() : Flow<List<CountryEntity>>
}