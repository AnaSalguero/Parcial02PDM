package com.pdm0126.parcial2rankeduca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pdm0126.parcial2rankeduca.Navigation.RankedUCA_App
import com.pdm0126.parcial2rankeduca.ui.theme.Parcial2RankedUCATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Parcial2RankedUCATheme() {
                RankedUCA_App()
            }
        }
    }
}