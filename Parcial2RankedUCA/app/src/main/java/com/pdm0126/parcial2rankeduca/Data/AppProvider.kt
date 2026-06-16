package com.pdm0126.parcial2rankeduca.Data

import android.content.Context
import com.pdm0126.parcial2rankeduca.Data.Database.AppDatabase
import com.pdm0126.parcial2rankeduca.Data.Repository.OptionRepository
import com.pdm0126.parcial2rankeduca.Data.Repository.OptionRepositoryImpl
import com.pdm0126.parcial2rankeduca.Data.Repository.QuestionRepository
import com.pdm0126.parcial2rankeduca.Data.Repository.QuestionRepositoryImpl

class AppProvider(context: Context) {

    private val appDatabase = AppDatabase.getDatabase(context)
    private val questionDao = appDatabase.questionDao()
    private val optionDao = appDatabase.optionDao()
    private val questionRepository: QuestionRepository =
        QuestionRepositoryImpl(questionDao)
    private val optionRepository: OptionRepository =
        OptionRepositoryImpl(optionDao)

    fun provideQuestionRepository(): QuestionRepository {
        return questionRepository
    }
    fun provideOptionRepository(): OptionRepository {
        return optionRepository
    }
}