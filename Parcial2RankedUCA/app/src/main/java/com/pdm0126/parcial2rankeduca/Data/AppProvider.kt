package com.pdm0126.parcial2rankeduca.Data

import android.content.Context
import com.pdm0126.parcial2rankeduca.Data.Database.AppDatabase
import com.pdm0126.parcial2rankeduca.Data.Database.Dao.OptionDao
import com.pdm0126.parcial2rankeduca.Data.Repository.OptionRepository
import com.pdm0126.parcial2rankeduca.Data.Repository.OptionRepositoryImpl
import com.pdm0126.parcial2rankeduca.Data.Repository.QuestionOfflineFirstRepository
import com.pdm0126.parcial2rankeduca.Data.Repository.QuestionOfflineFirstRepositoryImpl
import com.pdm0126.parcial2rankeduca.Data.Database.Dao.QuestionDao

class AppProvider(context: Context) {

    private val appDatabase = AppDatabase.getDatabase(context)
    private val questionDao = appDatabase.questionDao()
    private val optionDao = appDatabase.optionDao()
    private val questionRepository: QuestionOfflineFirstRepository =
        QuestionOfflineFirstRepositoryImpl(questionDao,optionDao)
    fun provideQuestionRepository(): QuestionOfflineFirstRepository {
        return questionRepository
    }
}