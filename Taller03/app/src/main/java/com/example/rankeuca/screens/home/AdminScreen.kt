package com.example.rankeuca.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.rankeuca.Routes
import com.example.rankeuca.viewmodel.ViewModelCoso

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminScreen(
    backStack: NavBackStack<NavKey>,
    viewModelCoso: ViewModelCoso
) {
    val options by viewModelCoso.option.collectAsState()
    var showSheet by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text("Admin - Opciones") },
                actions = {
                    TextButton(onClick = { showSheet = true }) {
                        Icon(Icons.Default.Add, contentDescription = "Nueva opción")
                        Spacer(Modifier.width(4.dp))
                        Text("Nueva")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            if (options.isEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize().weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("No hay opciones todavía", style = MaterialTheme.typography.titleMedium)
                    Text("Toca Nueva para crear la primera.", color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize().weight(1f),
                    contentPadding = PaddingValues(vertical = 4.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(items = options, key = { it.id }) { option ->
                        ElevatedCard(modifier = Modifier.fillMaxWidth()) {
                            ListItem(
                                headlineContent = { Text(option.name) },
                                supportingContent = { Text(option.imageURL, style = MaterialTheme.typography.bodySmall) },
                                trailingContent = {
                                    IconButton(onClick = { viewModelCoso.deleteOption(option) }) {
                                        Icon(Icons.Default.Delete, contentDescription = "Borrar", tint = MaterialTheme.colorScheme.error)
                                    }
                                }
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(12.dp))

            Button(
                onClick = { backStack.add(Routes.Home) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ir a Votar")
            }
        }
    }

    if (showSheet) {
        OptionBottomSheet(
            onSave = { name, imageUrl -> viewModelCoso.addOption(name, imageUrl) },
            onDismiss = { showSheet = false }
        )
    }
}