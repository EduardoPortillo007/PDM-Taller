package com.example.foodspot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.foodspot.navigation.Screens
import com.example.foodspot.ui.screens.PantallaHome
import com.example.foodspot.ui.screens.PantallaDetalles
import com.example.foodspot.ui.screens.PantallaBusqueda
import com.example.foodspot.ui.theme.FoodSpotTheme
import com.example.foodspot.ui.viewmodel.RestaurantViewModel
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodSpotTheme {
                val backStack = rememberNavBackStack(Screens.Principal)
                //crea
                val viewModel: RestaurantViewModel = viewModel()
                //obtiene valor
                val restaurants by viewModel.restaurants.collectAsState()

                NavDisplay(
                    backStack = backStack,
                    entryProvider = entryProvider {
                        entry<Screens.Principal> {
                            PantallaHome(
                                backStack = backStack,
                                restaurants = restaurants
                            )
                        }
                        entry<Screens.Detalles> { entry ->
                            PantallaDetalles(
                                backStack = backStack,
                                restaurantId = entry.restaurantId,
                                restaurants = restaurants
                            )
                        }
                        entry<Screens.Busqueda> { entry ->
                            PantallaBusqueda(
                                backStack = backStack,
                                query = entry.query,
                                restaurants = restaurants
                            )
                        }
                    }
                )
            }
        }
    }
}