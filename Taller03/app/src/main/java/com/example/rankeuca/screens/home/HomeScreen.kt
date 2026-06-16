package com.example.rankeuca.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.rankeuca.Routes
import com.example.rankeuca.viewmodel.ViewModelCoso

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    backStack: NavBackStack<NavKey>,
    questionId: Int
) {
    val viewModelCoso: ViewModelCoso = viewModel(factory = ViewModelCoso.provideFactory(questionId))
    val options by viewModelCoso.option.collectAsState()
    var votedOptionId by remember { mutableStateOf<Int?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text("RankeUca - Vota") },
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize().weight(1f),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(options) { option ->
                    val isVoted = votedOptionId == option.id
                    OutlinedCard(
                        onClick = {
                            if (votedOptionId == null) {
                                viewModelCoso.vote(option.id)
                                votedOptionId = option.id
                            }
                        },
                        modifier = Modifier.fillMaxWidth().padding(8.dp),
                        border = if (isVoted) BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
                        else CardDefaults.outlinedCardBorder()
                    ) {
                        Column {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(option.imageURL).crossfade(true).build(),
                                modifier = Modifier.fillMaxWidth().height(150.dp),
                                contentScale = ContentScale.Crop,
                                contentDescription = option.name
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = option.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                                if (isVoted) Text("Votado ✓", color = MaterialTheme.colorScheme.primary)
                            }
                        }
                    }
                }
            }

            if (votedOptionId != null) {
                Button(
                    onClick = { backStack.add(Routes.Resultados(questionId)) },
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                ) {
                    Text("Ir a resultados", fontSize = 18.sp)
                }
            }
        }
    }
}