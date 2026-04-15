package com.example.taller1.ui.theme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.taller1.R
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.OutlinedCard

@Composable
fun Preguntas(onFinish: (Int) -> Unit) {
    val context = LocalContext.current

    val preguntas = listOf(
        Opciones(
            texto = context.getString(R.string.pregunta1),
            opciones = listOf(
                context.getString(R.string.P1_1),
                context.getString(R.string.P1_2),
                context.getString(R.string.P1_3),
                context.getString(R.string.P1_4)
            ),
            respuestaCorrecta = 0
        ),
        Opciones(
            texto = context.getString(R.string.pregunta2),
            opciones = listOf(
                context.getString(R.string.P2_1),
                context.getString(R.string.P2_2),
                context.getString(R.string.P2_3),
                context.getString(R.string.P2_4)
            ),
            respuestaCorrecta = 1
        ),
        Opciones(
            texto = context.getString(R.string.pregunta3),
            opciones = listOf(
                context.getString(R.string.P3_1),
                context.getString(R.string.P3_2),
                context.getString(R.string.P3_3),
                context.getString(R.string.P3_4)
            ),
            respuestaCorrecta = 0
        )
    )

    var preguntaActual by remember { mutableStateOf(0) }
    var puntaje by remember { mutableStateOf(0) }
    var respondida by remember { mutableStateOf(false) }

    val pregunta = preguntas[preguntaActual]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pregunta ${preguntaActual + 1} de ${preguntas.size}", fontSize = 16.sp)
        Text(text = "Puntaje: $puntaje de ${preguntas.size}", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedCard(
            modifier = Modifier.fillMaxWidth().height(120.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = pregunta.texto,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        pregunta.opciones.forEachIndexed { index, opcion ->
            Button(
                onClick = {
                    respondida = true
                    if (index == pregunta.respuestaCorrecta) puntaje++
                },
                enabled = !respondida,
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
            ) {
                Text(text = opcion)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (respondida) {
            Button(
                onClick = {
                    if (preguntaActual < preguntas.size - 1) {
                        preguntaActual++
                        respondida = false
                    } else {
                        onFinish(puntaje)
                    }
                }
            ) {
                Text(text = if (preguntaActual < preguntas.size - 1) "Siguiente" else "Ver Resultados")
            }
        }
    }
}