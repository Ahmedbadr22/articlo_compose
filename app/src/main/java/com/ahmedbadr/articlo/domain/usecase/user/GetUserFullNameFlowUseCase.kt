package com.ahmedbadr.articlo.domain.usecase.user

import com.auth0.android.jwt.JWT
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetUserFullNameFlowUseCase(
    private val getAccessTokenFlowUseCase: GetAccessTokenFlowUseCase
) {
    operator fun invoke() : Flow<String> = getAccessTokenFlowUseCase().map { token ->
        val jwt = JWT(token)
        jwt.claims["fullname"]?.asString() ?: ""
    }
}