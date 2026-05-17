package com.example.foodspot.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.foodspot.data.model.Restaurant
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaBusqueda(
    backStack: NavBackStack<NavKey>,
    query: String,
    restaurants: List<Restaurant>
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Resultados: $query") },
                navigationIcon = {
                    Button(onClick = { backStack.removeLastOrNull() }) {
                        Text("Regresar")
                    }
                }
            )
        }
    ) { paddingValues ->
        val resultados = restaurants.filter {
            it.name.contains(query, ignoreCase = true)
        }

        if (resultados.isEmpty()){
            Box(modifier = Modifier.fillMaxSize().padding(paddingValues))
            { Text("No hay resultados para $query")}

        }
        LazyColumn(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            items(resultados){restaurant->
                OutlinedCard(modifier = Modifier.fillMaxSize().padding(10.dp)) {
                    AsyncImage(
                        model = restaurant.imageUrl,
                        contentDescription = restaurant.name,
                        modifier = Modifier.fillMaxWidth().height(100.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = restaurant.name,
                        modifier = Modifier.padding(8.dp)
                    )
                }

            }
        }
    }
}