package com.ahmedbadr.articlo.data.repository.country

import com.ahmedbadr.articlo.app.utils.resource.NetworkResource
import com.ahmedbadr.articlo.data.mappers.toCountryEntity
import com.ahmedbadr.articlo.data.model.entities.CountryEntity
import com.ahmedbadr.articlo.data.model.response.CountryResponse
import com.ahmedbadr.articlo.data.source.local.country.CountryLocalDataSource
import com.ahmedbadr.articlo.data.source.remote.country.CountryRemoteDataSource
import com.ahmedbadr.articlo.domain.repository.CountryRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext

class CountryRepositoryImpl(
    private val countryRemoteDataSource: CountryRemoteDataSource,
    private val countryLocalDataSource: CountryLocalDataSource,
) : CountryRepository {

    override suspend fun listCountriesFromRemoteThenInsertInLocal() {
        withContext(Dispatchers.IO) {
            val resources: NetworkResource<List<CountryResponse>> = countryRemoteDataSource.listCountriesFromRemote()
            if (resources is NetworkResource.Success) {
                val countriesEntity: List<CountryEntity> = resources.data.map(CountryResponse::toCountryEntity)
                countryLocalDataSource.addCountriesToLocal(countriesEntity)
            }
        }
    }

    override fun getCountriesFlow(): Flow<List<CountryEntity>> = countryLocalDataSource.listCountriesFlowFromLocal()

}