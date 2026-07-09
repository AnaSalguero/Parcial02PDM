package com.pdm0126.parcial2rankeduca.Data.Repository

import com.pdm0126.parcial2rankeduca.Data.Model.Question
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {
    fun getQuestion(): Flow<List<Question>>
    suspend fun addQuestion(title:String, id:Int)
    suspend fun deleteQuestion(question: Question)
    suspend fun updateQuestion(question: Question)
}