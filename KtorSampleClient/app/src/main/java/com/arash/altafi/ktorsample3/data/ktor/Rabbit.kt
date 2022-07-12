package com.arash.altafi.ktorsample3.data.ktor

import kotlinx.serialization.Serializable

@Serializable
data class Rabbit(
    val name: String,
    val description: String,
    val imageUrl: String
)
