package com.pdm0126.parcial2rankeduca.Data.Repository

import com.pdm0126.parcial2rankeduca.Data.Database.Dao.QuestionDao
import com.pdm0126.parcial2rankeduca.Data.Model.Question
import com.pdm0126.parcial2rankeduca.Data.Database.Entities.QuestionEntity
import com.pdm0126.parcial2rankeduca.Data.Database.Entities.toModel
import com.pdm0126.parcial2rankeduca.Data.Model.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuestionRepositoryImpl(private val questionDao: QuestionDao): QuestionRepository {
    override fun getQuestion(): Flow<List<Question>> {
        return questionDao.getQuestionsWithOptions().map { list ->
            list.map { it.toModel() }
        }
    }

    override suspend fun addQuestion(title: String) {
        questionDao.insertQuestion(QuestionEntity(title = title))
    }

    override suspend fun deleteQuestion(question: Question) {
        questionDao.deleteQuestion(question.toEntity())
    }
}