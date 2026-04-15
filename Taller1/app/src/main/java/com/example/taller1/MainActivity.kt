package com.example.taller1
import com.example.taller1.ui.theme.Preguntas
import com.example.taller1.ui.theme.ResultadoScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.material3.OutlinedCard
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var mostrarQuiz by remember { mutableStateOf(false) }

            if (!mostrarQuiz) {
                Pantalla(
                    onComenzarQuiz = { mostrarQuiz = true }
                )
            } else {
                QuizContainer()
            }
        }
    }
}

@Composable
fun Pantalla(onComenzarQuiz: () -> Unit){
    var checked by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 46.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedCard(
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5B027)),
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
        ) {
            Text(
                text = "AndroidPedia",
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                textAlign = TextAlign.Left,
                fontSize = 18.sp
            )
            Text(
                text = "¿Cuánto sabes de Android?",
                modifier = Modifier.fillMaxWidth().padding(25.dp),
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
            Text(
                text = "Eduardo Ernesto Portillo Ramírez - 00044923",
                modifier = Modifier.fillMaxWidth().padding(20.dp),
                textAlign = TextAlign.Center,
                fontSize = 15.sp
            )
        }
        OutlinedCard(
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF54927)),
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        if (checked) onComenzarQuiz()
                    },
                    modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp).height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "Comenzar Quiz", fontSize = 20.sp)
                }
            }
        }
        OutlinedCard(
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5276C)),
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
        ) {
                Text(
                text = "Acepto terminos y condiciones",
                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                    textAlign = TextAlign.Left,
                    fontSize = 18.sp
                )
                Text("")
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it }
                )

        }
    }
}

@Composable
fun QuizContainer() {
    var mostrarResultados by remember { mutableStateOf(false) }
    var puntaje by remember { mutableStateOf(0) }

    if (!mostrarResultados) {
        Preguntas(onFinish = { puntajeFinal ->
            puntaje = puntajeFinal
            mostrarResultados = true
        })
    } else {
        ResultadoScreen(
            puntaje = puntaje,
            onReiniciar = { mostrarResultados = false }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPreview() {
    Pantalla(
        onComenzarQuiz = {}
    )
}