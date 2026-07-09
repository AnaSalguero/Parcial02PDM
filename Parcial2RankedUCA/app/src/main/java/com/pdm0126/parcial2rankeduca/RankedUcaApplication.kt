package com.pdm0126.parcial2rankeduca

import android.app.Application
import com.pdm0126.parcial2rankeduca.Data.AppProvider

class RankedUcaApplication: Application() {
    val appProvider by lazy { AppProvider(this) }
}