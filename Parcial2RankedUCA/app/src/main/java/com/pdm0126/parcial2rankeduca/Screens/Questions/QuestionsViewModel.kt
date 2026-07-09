package com.pdm0126.parcial2rankeduca.Screens.Questions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.pdm0126.parcial2rankeduca.Data.Model.Question
import com.pdm0126.parcial2rankeduca.RankedUcaApplication
import com.pdm0126.parcial2rankeduca.Data.Repository.QuestionRepository
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.pdm0126.parcial2rankeduca.Data.Repository.QuestionOfflineFirstRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class QuestionsViewModel(private val questionRepository: QuestionOfflineFirstRepository): ViewModel(){

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init{
        refresh()
    }

    val question: StateFlow<List<Question>> =
        questionRepository.getQuestions()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )
    fun addQuestion(title:String) {
        viewModelScope.launch {
            questionRepository.createQuestion(title)
        }
    }
    fun deleteQuestion(id:Int){
        viewModelScope.launch {
            questionRepository.deleteQuestion(id)
        }
    }

    private fun refresh() {
        viewModelScope.launch {
            _isRefreshing.value = true
            _error.value = null
            try{
                questionRepository.refresh()
            }catch (_: Exception){
                if (question.value.isEmpty()) {
                    _error.value = "Sin conexión y sin datos en caché"
                }
            }
            _isRefreshing.value= false
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