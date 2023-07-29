package com.ahmedbadr.articlo.ui.presentation.screens.selectCountry.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmedbadr.articlo.domain.model.data.Country
import com.ahmedbadr.articlo.domain.usecase.country.GetCountriesFlowUseCase
import com.ahmedbadr.articlo.domain.usecase.country.ListCountriesFromRemoteToLocalUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CountryViewModel(
    getCountriesFlowUseCase: GetCountriesFlowUseCase,
    private val listCountriesFromRemoteToLocalUseCase: ListCountriesFromRemoteToLocalUseCase
) : ViewModel() {

    private var _countriesStateFlow: MutableStateFlow<List<Country>> = MutableStateFlow(emptyList())
    val countriesStateFlow: StateFlow<List<Country>>
        get() = _countriesStateFlow.asStateFlow()

    init {
        viewModelScope.launch {
            getCountriesFlowUseCase().collectLatest { countriesList ->
                _countriesStateFlow.value = countriesList
            }
        }
    }

    fun listCountriesFromRemoteToLocal() {
        viewModelScope.launch {
            listCountriesFromRemoteToLocalUseCase()
        }
    }
}