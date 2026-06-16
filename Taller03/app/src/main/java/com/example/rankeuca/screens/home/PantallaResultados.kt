package com.example.rankeuca.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.rankeuca.viewmodel.ViewModelCoso

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaResultados(
    backStack: NavBackStack<NavKey>,
    viewModelCoso: ViewModelCoso
) {
    val options by viewModelCoso.option.collectAsState()
    val sortedOptions = options.sortedByDescending { it.votes }
    val pullState = rememberPullToRefreshState()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text("RankeUca - Resultados") },
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .pullToRefresh(
                        state = pullState,
                        isRefreshing = false,
                        onRefresh = {}
                    )
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    items(sortedOptions) { option ->
                        OutlinedCard(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(option.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                                Text("${option.votes} votos", fontSize = 16.sp)
                            }
                        }
                    }
                }

                PullToRefreshDefaults.Indicator(
                    state = pullState,
                    isRefreshing = false,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }

            Button(
                onClick = { backStack.removeLastOrNull() },
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Text("Nuevo (Volver a Votar)", fontSize = 18.sp)
            }
        }
    }
}