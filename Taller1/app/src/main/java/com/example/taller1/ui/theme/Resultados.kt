package com.example.taller1.ui.theme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.taller1.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
@Composable
fun ResultadoScreen(puntaje: Int, onReiniciar: () -> Unit) {
    val context = LocalContext.current

    val mensaje = when (puntaje) {
        0 -> context.getString(R.string.msg1)
        1 -> context.getString(R.string.msg2)
        2 -> context.getString(R.string.msg3)
        3 -> context.getString(R.string.msg4)
        else -> ""
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Obtuviste $puntaje de 3", fontSize = 28.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = mensaje, fontSize = 20.sp)

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { onReiniciar() }) {
            Text(text = "Reiniciar Quiz")
        }
    }
}