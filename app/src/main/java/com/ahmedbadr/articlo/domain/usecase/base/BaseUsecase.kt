package com.ahmedbadr.articlo.domain.usecase.base

import com.ahmedbadr.articlo.R
import com.ahmedbadr.articlo.app.utils.network.FailureStatus
import com.ahmedbadr.articlo.app.utils.resource.Resource


interface BaseUseCase {
    suspend operator fun invoke()
}