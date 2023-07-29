package com.ahmedbadr.articlo.app.utils.network

import android.util.Log
import com.ahmedbadr.articlo.app.utils.resource.NetworkResource
import retrofit2.Response

enum class FailureStatus {
    BAD_REQUEST,
    UN_AUTHORIZED,
    INTERNAL_ERROR,
    NO_INTERNET,
    UN_KNOWN,
    NOT_FOUND,
}

inline fun <reified T> safeApiCall(apiCall: () -> Response<T>): NetworkResource<T> {
    return try {
        val apiResponse = apiCall.invoke() as Response<*>
        when (apiResponse.code()) {
            in 200..299 -> {
                val data = apiResponse.body() as T
                NetworkResource.Success(data)
            }
            401 -> {
                NetworkResource.Failure(FailureStatus.UN_AUTHORIZED)
            }
            400 -> {
                NetworkResource.Failure(FailureStatus.BAD_REQUEST)
            }
            404 -> {
                NetworkResource.Failure(FailureStatus.NO_INTERNET)
            }
            500 -> {
                NetworkResource.Failure(FailureStatus.INTERNAL_ERROR)
            }
            else -> {
                Log.d("NetworkUtil", "${apiResponse.code()}")
                NetworkResource.Failure(FailureStatus.UN_KNOWN)
            }
        }
    }
    catch (e: Exception){
        Log.d("NetworkUtils", "Error ==> ${e.message} | ${e.localizedMessage} | $e")
        NetworkResource.Failure(FailureStatus.NOT_FOUND)
    }
}