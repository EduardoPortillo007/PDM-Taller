package com.example.foodspot.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import com.example.foodspot.data.model.Restaurant
import com.example.foodspot.navigation.Screens
import androidx.compose.ui.text.input.ImeAction
import androidx.navigation3.runtime.NavKey
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarBusqueda(
    query: String,
    onQueryChange: (String) -> Unit,
    onBuscar: () -> Unit
) {
    TopAppBar(
        title = {
            TextField(
                value = query,
                onValueChange = onQueryChange,
                placeholder = { Text("Buscar...") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = { onBuscar() }
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    )
}

@Composable
fun PantallaHome(
    backStack: NavBackStack<NavKey>,
    restaurants: List<Restaurant>      //recibe ViewModel
) {
    var query by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopBarBusqueda(
                query = query,
                onQueryChange = { query = it },
                onBuscar = {
                    backStack.add(Screens.Busqueda(query))
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(paddingValues)) {

            item {
                Text(
                    text = "Pizzas",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(16.dp)
                )
                LazyRow {

                    items(restaurants.filter { it.categories.contains("Pizzas") }) { restaurant ->
                        OutlinedCard(
                            onClick = { backStack.add(Screens.Detalles(restaurant.id)) },
                            modifier = Modifier.width(150.dp).padding(8.dp)
                        ) {
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

            item {
                Text(
                    text = "Hamburguesas",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(16.dp)
                )
                LazyRow {
                    items(restaurants.filter { it.categories.contains("Hamburguesa") }) { restaurant ->
                        OutlinedCard(
                            onClick = { backStack.add(Screens.Detalles(restaurant.id)) },
                            modifier = Modifier.width(150.dp).padding(8.dp)
                        ){
                            AsyncImage(  //imagen
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

            item {
                Text(
                    text = "Comida Italiana",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(16.dp)
                )
                LazyRow {
                    items(restaurants.filter { it.categories.contains("Italiana") }) { restaurant ->
                        OutlinedCard(
                            onClick = { backStack.add(Screens.Detalles(restaurant.id)) },
                            modifier = Modifier.width(150.dp).padding(8.dp)
                        ) {
                            AsyncImage(  // ✅ agrega la imagen
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

            item {
                Text(
                    text = "Pollo",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(16.dp)
                )
                LazyRow {
                    items(restaurants.filter { it.categories.contains("Pollo") }) { restaurant ->
                        OutlinedCard(
                            onClick = { backStack.add(Screens.Detalles(restaurant.id)) },
                            modifier = Modifier.width(150.dp).padding(8.dp)
                        ){
                            AsyncImage(  // ✅ agrega la imagen
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

            item {
                Text(
                    text = "Postres",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(16.dp)
                )
                LazyRow {
                    items(restaurants.filter { it.categories.contains("Postres") }) { restaurant ->
                        OutlinedCard(
                            onClick = { backStack.add(Screens.Detalles(restaurant.id)) },
                            modifier = Modifier.width(150.dp).padding(8.dp)
                        ) {
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
    }
}