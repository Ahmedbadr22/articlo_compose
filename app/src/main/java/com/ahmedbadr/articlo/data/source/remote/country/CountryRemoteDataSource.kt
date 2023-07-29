package com.ahmedbadr.articlo.data.source.remote.country

import com.ahmedbadr.articlo.app.utils.resource.NetworkResource
import com.ahmedbadr.articlo.data.model.response.CountryResponse

interface CountryRemoteDataSource {
    suspend fun listCountriesFromRemote() : NetworkResource<List<CountryResponse>>
}