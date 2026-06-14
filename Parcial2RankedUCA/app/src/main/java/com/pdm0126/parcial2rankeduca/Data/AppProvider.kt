package com.pdm0126.parcial2rankeduca.Data

import android.content.Context
import com.pdm0126.parcial2rankeduca.Data.Database.AppDatabase
import com.pdm0126.parcial2rankeduca.Data.Repository.OptionRepository
import com.pdm0126.parcial2rankeduca.Data.Repository.OptionRepositoryImpl

class AppProvider(context: Context) {

    private val appDatabase = AppDatabase.getDatabase(context)
    private val optionDao = appDatabase.optionDao()

    private val optionRepository: OptionRepository =
        OptionRepositoryImpl(optionDao)

    fun provideOptionRepository(): OptionRepository {
        return optionRepository
    }
}