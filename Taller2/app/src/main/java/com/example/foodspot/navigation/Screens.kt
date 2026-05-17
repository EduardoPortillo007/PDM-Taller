package com.example.foodspot.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class Screens : NavKey {

    @Serializable
    data object Principal : Screens()

    @Serializable
    data class Detalles(val restaurantId: Int) : Screens()

    @Serializable
    data class Busqueda(val query: String) : Screens()
}