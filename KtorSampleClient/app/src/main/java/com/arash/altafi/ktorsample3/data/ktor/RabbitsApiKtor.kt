package com.arash.altafi.ktorsample3.data.ktor

interface RabbitsApiKtor {
    suspend fun getRandomRabbitKtor(): Rabbit?
}