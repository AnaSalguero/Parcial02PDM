package com.pdm0126.parcial2rankedduca.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.parcial2rankeduca.Navigation.Routes
import com.pdm0126.parcial2rankeduca.Screens.Home.HomeScreen
import com.pdm0126.parcial2rankeduca.Screens.Results.ResultScreen
import com.pdm0126.parcial2rankeduca.Screens.Home.HomeScreen

@Composable
fun RankedUCA_App() {
  val backStack = rememberNavBackStack(Routes.Home)

  NavDisplay(
    backStack = backStack,
    onBack = { backStack.removeLastOrNull() },
    entryProvider = entryProvider {
      entry<Routes.Home> {
        HomeScreen(navResult = {
          backStack.add(Routes.Results)
        })
      }
      entry<Routes.Results>{
        ResultScreen(
          navBack = {
            backStack.removeLastOrNull()
          }
        )
      }
    },
  )
}