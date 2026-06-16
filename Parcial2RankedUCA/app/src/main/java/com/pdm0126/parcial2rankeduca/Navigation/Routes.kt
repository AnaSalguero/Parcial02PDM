package com.pdm0126.parcial2rankeduca.Navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes: NavKey{
    @Serializable
    data object Home : Routes()
    @Serializable
    data object  Results: Routes()
    @Serializable
    data object Question: Routes()
    @Serializable
    data class Option(val questionId:Int): Routes()

}

