package com.ahmedbadr.articlo.domain.usecase.country

import com.ahmedbadr.articlo.domain.repository.CountryRepository

class ListCountriesFromRemoteToLocalUseCase(
    private val countryRepository: CountryRepository
) {

    suspend operator fun invoke() {
        countryRepository.listCountriesFromRemoteThenInsertInLocal()
    }
}