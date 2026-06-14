package com.pdm0126.parcial2rankeduca.Data

import android.app.Application

class RankedUcaApplication: Application() {
    val appProvider by lazy { AppProvider(this) }
}