package com.arash.altafi.ktorsample3.data.retrofit

import retrofit2.http.GET

interface RabbitsApi {

    @GET("/randomRabbit")
    suspend fun getRandomRabbit(): Rabbit

    companion object {
        const val BASE_URL = "http://192.168.1.101:8010"
    }
}