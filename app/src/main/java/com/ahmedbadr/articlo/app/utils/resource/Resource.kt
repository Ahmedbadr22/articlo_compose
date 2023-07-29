package com.ahmedbadr.articlo.app.utils.resource

import androidx.annotation.StringRes
import com.ahmedbadr.articlo.app.utils.network.FailureStatus

sealed class Resource<out T>  {
    data class Success<out T>(val data: T?) : Resource<T>()
    data class NetworkError(@StringRes val error: Int) : Resource<Nothing>()
    data class Error(val errors: Any) : Resource<Nothing>()
}

sealed class NetworkResource<out T>  {
    data class Success<out T>(val data: T) : NetworkResource<T>()
    data class Failure(val failureStatus: FailureStatus) : NetworkResource<Nothing>()
}