package com.ahmedbadr.articlo.data.source.local.country

import com.ahmedbadr.articlo.app.db.dao.CountryDao
import com.ahmedbadr.articlo.data.model.entities.CountryEntity
import kotlinx.coroutines.flow.Flow

class CountryLocalDataSourceImpl(
    private val countryDao: CountryDao
) : CountryLocalDataSource {
    override suspend fun addCountryToLocal(countryEntity: CountryEntity) {
        countryDao.insertCountry(countryEntity)
    }

    override suspend fun addCountriesToLocal(countries: List<CountryEntity>) {
        countryDao.insertCountries(countries)
    }

    override suspend fun listCountriesFromLocal(): List<CountryEntity> = countryDao.listCountries()

    override fun listCountriesFlowFromLocal(): Flow<List<CountryEntity>> =
        countryDao.listCountriesFlow()

}