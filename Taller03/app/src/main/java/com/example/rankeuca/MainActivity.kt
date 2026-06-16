package com.example.rankeuca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import coil3.ImageLoader
import coil3.SingletonImageLoader
import coil3.network.okhttp.OkHttpNetworkFetcherFactory
import com.example.rankeuca.ui.theme.RankeUCATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        SingletonImageLoader.setSafe {
            ImageLoader.Builder(it)
                .components {
                    add(OkHttpNetworkFetcherFactory())
                }
                .build()
        }

        setContent {
            RankeUCATheme {
                RankeUCA_App()
            }
        }
    }
}