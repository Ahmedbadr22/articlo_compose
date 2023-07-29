package com.ahmedbadr.articlo.domain.usecase.user

import com.ahmedbadr.articlo.data.source.local.user.UserLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetIsAuthenticatedUseCase(
    private val getAccessTokenFlowUseCase: GetAccessTokenFlowUseCase
)  {
    operator fun invoke(): Flow<Boolean> = getAccessTokenFlowUseCase().map { token ->
        token.isNotEmpty()
    }
}