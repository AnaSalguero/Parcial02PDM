package com.pdm0126.parcial2rankeduca.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.parcial2rankeduca.Navigation.Routes
import com.pdm0126.parcial2rankeduca.Screens.Home.HomeScreen
import com.pdm0126.parcial2rankeduca.Screens.Options.OptionsScreen
import com.pdm0126.parcial2rankeduca.Screens.Results.ResultScreen
import com.pdm0126.parcial2rankeduca.Screens.Questions.QuestionScreen

@Composable
fun RankedUCA_App() {
  //Para probar solamente la conección entre las preguntas y opciones se hara que la app inicie en la pantalla de preguntas
  val backStack = rememberNavBackStack(Routes.Question)

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
          }
        )
      }

    },
  )
}