package com.ahmedbadr.articlo.domain.usecase.user

import com.ahmedbadr.articlo.data.source.local.user.UserLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAccessTokenFlowUseCase(
    private val userLocalDataSource: UserLocalDataSource
)  {
    operator fun invoke(): Flow<String> = userLocalDataSource.getAccessTokenFlow
}