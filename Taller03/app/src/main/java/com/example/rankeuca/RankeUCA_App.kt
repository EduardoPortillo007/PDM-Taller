package com.example.rankeuca

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.rankeuca.screens.home.AdminScreen
import com.example.rankeuca.screens.home.HomeScreen
import com.example.rankeuca.screens.home.PantallaResultados
import com.example.rankeuca.screens.home.QuestionsScreen

@Composable
fun RankeUCA_App() {
    val backStack = rememberNavBackStack(Routes.Questions)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Questions> {
                QuestionsScreen(backStack = backStack)
            }
            entry<Routes.Options> { entry ->
                AdminScreen(backStack = backStack, questionId = entry.questionId)
            }
            entry<Routes.Home> { entry ->
                HomeScreen(backStack = backStack, questionId = entry.questionId)
            }
            entry<Routes.Resultados> { entry ->
                PantallaResultados(backStack = backStack, questionId = entry.questionId)
            }
        },
    )
}