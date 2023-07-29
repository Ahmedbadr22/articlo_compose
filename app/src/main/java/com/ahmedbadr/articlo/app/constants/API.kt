package com.ahmedbadr.articlo.app.constants

object API {
    const val BASE_URL = "https://ee4b-197-56-28-146.ngrok-free.app"

    // Apps
    private const val AUTHENTICATION_APP = "/authentication"
    private const val COUNTRY_APP = "/country"

    // auth
    const val LOGIN = "$AUTHENTICATION_APP/login"
    const val CREATE_ACCOUNT = "$AUTHENTICATION_APP/create-user-account"

    // country
    const val LIST_COUNTRIES = "$COUNTRY_APP/list-countries"
}