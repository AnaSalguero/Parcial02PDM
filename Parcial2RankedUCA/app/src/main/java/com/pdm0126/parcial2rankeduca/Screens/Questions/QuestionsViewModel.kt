package com.pdm0126.parcial2rankeduca.Screens.Questions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.pdm0126.parcial2rankeduca.Data.Model.Question
import com.pdm0126.parcial2rankeduca.Data.RankedUcaApplication
import com.pdm0126.parcial2rankeduca.Data.Repository.QuestionRepository
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class QuestionsViewModel(private val questionRepository: QuestionRepository): ViewModel(){
    val question: StateFlow<List<Question>> =
        questionRepository.getQuestion()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )
    fun addQuestion(title:String) {
        viewModelScope.launch {
            questionRepository.addQuestion(title)
        }
    }
    fun deleteOption(question: Question){
        viewModelScope.launch {
            questionRepository.deleteQuestion(question)
        }
    }
    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as RankedUcaApplication
                QuestionsViewModel(app.appProvider.provideQuestionRepository())
            }
        }
    }
}