package com.example.rankeuca

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.rankeuca.screens.home.AdminScreen
import com.example.rankeuca.screens.home.HomeScreen
import com.example.rankeuca.screens.home.PantallaResultados
import com.example.rankeuca.viewmodel.ViewModelCoso

@Composable
fun RankeUCA_App() {
    val backStack = rememberNavBackStack(Routes.Admin)
    val viewModel: ViewModelCoso = viewModel(factory = ViewModelCoso.Factory)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Admin> {
                AdminScreen(backStack = backStack, viewModelCoso = viewModel)
            }
            entry<Routes.Home> {
                HomeScreen(backStack = backStack, viewModelCoso = viewModel)
            }
            entry<Routes.Resultados> {
                PantallaResultados(backStack = backStack, viewModelCoso = viewModel)
            }
        },
    )
}