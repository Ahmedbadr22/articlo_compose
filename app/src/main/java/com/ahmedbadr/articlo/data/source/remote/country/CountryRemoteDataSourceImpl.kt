package com.ahmedbadr.articlo.data.source.remote.country

import com.ahmedbadr.articlo.app.utils.network.safeApiCall
import com.ahmedbadr.articlo.app.utils.resource.NetworkResource
import com.ahmedbadr.articlo.data.clientService.CountryClientService
import com.ahmedbadr.articlo.data.model.response.CountryResponse

class CountryRemoteDataSourceImpl(
    private val countryClientService: CountryClientService
) : CountryRemoteDataSource {

    override suspend fun listCountriesFromRemote(): NetworkResource<List<CountryResponse>> = safeApiCall {
        countryClientService.listCountries()
    }

}