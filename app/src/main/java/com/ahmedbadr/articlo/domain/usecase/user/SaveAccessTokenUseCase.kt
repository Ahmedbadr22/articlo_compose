package com.ahmedbadr.articlo.domain.usecase.user

import com.ahmedbadr.articlo.data.source.local.user.UserLocalDataSource
import com.ahmedbadr.articlo.domain.usecase.base.BaseIOUseCase

class SaveAccessTokenUseCase(
    private val userLocalDataSource: UserLocalDataSource
) : BaseIOUseCase<String, Boolean, Boolean>{

    override suspend fun invoke(input: String): Boolean {
        val isValid = validateInput(input)
        userLocalDataSource.saveAccessToken(input)
        return isValid
    }

    override fun validateInput(input: String): Boolean {
        return input.isNotEmpty()
    }

}