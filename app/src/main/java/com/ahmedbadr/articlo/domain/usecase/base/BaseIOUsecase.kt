package com.ahmedbadr.articlo.domain.usecase.base

import com.ahmedbadr.articlo.R
import com.ahmedbadr.articlo.app.utils.network.FailureStatus
import com.ahmedbadr.articlo.app.utils.resource.Resource


interface BaseIOUseCase<I, O, V> {
    suspend operator fun invoke(input: I) : O
    fun validateInput(input: I) : V

    fun handleFailMessage(failureStatus: FailureStatus) : Resource.NetworkError {
        val error =  when(failureStatus) {
            FailureStatus.BAD_REQUEST -> R.string.wrong_email_or_password
            FailureStatus.UN_AUTHORIZED -> R.string.wrong_email_or_password
            FailureStatus.INTERNAL_ERROR -> R.string.server_error
            FailureStatus.NO_INTERNET -> R.string.no_internet
            FailureStatus.UN_KNOWN -> R.string.unknown_error
            FailureStatus.NOT_FOUND -> R.string.not_found
        }

        return Resource.NetworkError(error)
    }
}