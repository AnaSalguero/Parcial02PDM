package com.pdm0126.parcial2rankeduca.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.parcial2rankeduca.Navigation.Routes
import com.pdm0126.parcial2rankeduca.Screens.Home.HomeScreen
import com.pdm0126.parcial2rankeduca.Screens.MenuScreen.MenuScreen
import com.pdm0126.parcial2rankeduca.Screens.Options.OptionsScreen
import com.pdm0126.parcial2rankeduca.Screens.Results.ResultScreen
import com.pdm0126.parcial2rankeduca.Screens.Questions.QuestionScreen

@Composable
fun RankedUCA_App() {
  val backStack = rememberNavBackStack(Routes.Menu)

  NavDisplay(
    backStack = backStack,
    onBack = { backStack.removeLastOrNull() },
    entryProvider = entryProvider {
      entry<Routes.Menu> {
        MenuScreen(
          navToHome = {
            backStack.add(Routes.Home)
          },
          navToQuestion = {
            backStack.add(Routes.Question)
          }
        )
      }
      entry<Routes.Home> {
        HomeScreen(
          navResult = {
            backStack.add(Routes.Results)
          },
          navBack = {
            backStack.removeLastOrNull()
          }
        )
      }
      entry<Routes.Results>{
        ResultScreen(
          navBack = {
            backStack.removeLastOrNull()
          }
        )
      }
      entry<Routes.Option> {route->
        key(route.questionId) {
          OptionsScreen(
            questionId = route.questionId,
            navBack = {
              backStack.removeLastOrNull()
            }
          )
        }
      }
      entry<Routes.Question> {
        QuestionScreen(
          onQuestionClick = { questionId->
            backStack.add(Routes.Option(questionId))
          },
          navBack = {
            backStack.removeLastOrNull()
          }
        )
      }

    },
  )
}