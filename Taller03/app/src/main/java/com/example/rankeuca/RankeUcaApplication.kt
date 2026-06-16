package com.example.rankeuca

import android.app.Application
import com.example.rankeuca.data.AppProvider

class RankeUcaApplication : Application() {
    val appProvider by lazy { AppProvider(this) }
}