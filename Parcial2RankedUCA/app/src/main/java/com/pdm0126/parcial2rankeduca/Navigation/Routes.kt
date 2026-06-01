package com.pdm0126.parcial2rankeduca.Navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes: NavKey{
    @Serializable
    data object Home : Routes()
    @Serializable
    data object  Results: Routes()

}

