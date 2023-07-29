package com.ahmedbadr.articlo.data.clientService

import com.ahmedbadr.articlo.app.constants.API
import com.ahmedbadr.articlo.data.model.response.CountryResponse
import retrofit2.Response
import retrofit2.http.GET

interface CountryClientService {
    @GET(API.LIST_COUNTRIES)
    suspend fun listCountries() : Response<List<CountryResponse>>
}