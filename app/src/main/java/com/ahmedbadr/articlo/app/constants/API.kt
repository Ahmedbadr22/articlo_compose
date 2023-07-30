package com.ahmedbadr.articlo.app.constants

object API {
    const val BASE_URL = "https://3812-154-179-2-101.ngrok-free.app"

    // Apps
    private const val AUTHENTICATION_APP = "/authentication"
    private const val COUNTRY_APP = "/country"
    private const val ARTICLE_APP = "/article"
    private const val TOPIC_APP = "/topic"

    // auth
    const val LOGIN = "$AUTHENTICATION_APP/login"
    const val CREATE_ACCOUNT = "$AUTHENTICATION_APP/create-user-account"

    // country
    const val LIST_COUNTRIES = "$COUNTRY_APP/list-countries"

    // Topic
    const val LIST_TOPICS = "$TOPIC_APP/list-topics"
}