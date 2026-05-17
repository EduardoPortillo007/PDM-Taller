package com.example.foodspot.ui.screens

import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.foodspot.data.model.Restaurant
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedCard
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaDetalles(
    backStack: NavBackStack<NavKey>,
    restaurantId: Int,
    restaurants: List<Restaurant>
) {
    val restaurant = restaurants.find { it.id == restaurantId }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(restaurant?.name ?: "    Restaurante") },
                navigationIcon = {
                    Button(onClick = { backStack.removeLastOrNull() }) {
                        Text("<-    Regresar")
                    }
                }
            )
        }
    )
    {paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(16.dp),horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text("Detalles del restaurant $restaurantId")
            Box {
                Text(
                    text = "Menú",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
            LazyColumn(modifier = Modifier.fillMaxSize().padding(paddingValues), verticalArrangement = Arrangement.spacedBy(20.dp))
            {

                items(restaurant?.menu ?: emptyList()){ dish->
                    OutlinedCard(
                        onClick = { },
                        modifier = Modifier.fillMaxSize()
                    ) {

                        AsyncImage(
                            model = dish.imageUrl,
                            contentDescription = dish.name,
                            modifier = Modifier.fillMaxWidth().height(100.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = dish.name,
                            modifier = Modifier.padding(8.dp)
                        )
                        Button(onClick = {Toast.makeText(context, "¡Orden confirmada!", Toast.LENGTH_SHORT).show()}) {
                            Text(" + Añadir")
                        }


                    }
                }
            }

        }
    }
}