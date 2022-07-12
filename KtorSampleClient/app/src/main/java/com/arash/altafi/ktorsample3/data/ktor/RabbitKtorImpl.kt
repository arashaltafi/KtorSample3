package com.arash.altafi.ktorsample3.data.ktor

import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class RabbitKtorImpl @Inject constructor(
    private val client: HttpClient
): RabbitsApiKtor {

    override suspend fun getRandomRabbitKtor(): Rabbit {
        return client.get { url(HttpRoutes.POSTS) }
    }
}