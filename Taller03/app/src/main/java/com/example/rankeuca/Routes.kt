package com.example.rankeuca

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class Routes : NavKey {
    @Serializable
    data object Admin : Routes()

    @Serializable
    data object Home : Routes()

    @Serializable
    data object Resultados : Routes()
}