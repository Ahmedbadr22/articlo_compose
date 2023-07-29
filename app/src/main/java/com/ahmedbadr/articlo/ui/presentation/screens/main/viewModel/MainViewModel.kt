package com.ahmedbadr.articlo.ui.presentation.screens.main.viewModel

import androidx.lifecycle.ViewModel
import com.ahmedbadr.articlo.domain.usecase.user.GetUserFullNameFlowUseCase
import kotlinx.coroutines.flow.Flow

class MainViewModel(
    private val getUserFullNameFlowUseCase: GetUserFullNameFlowUseCase
) : ViewModel() {

    val userFullNameFlow: Flow<String> = getUserFullNameFlowUseCase()

}