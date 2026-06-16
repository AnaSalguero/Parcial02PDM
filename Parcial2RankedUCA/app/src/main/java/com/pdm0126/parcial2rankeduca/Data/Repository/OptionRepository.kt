package com.pdm0126.parcial2rankeduca.Data.Repository

import com.pdm0126.parcial2rankeduca.Data.Model.Option
import kotlinx.coroutines.flow.Flow

interface OptionRepository{
    fun getOptions(questionId: Int): Flow<List<Option>>
    suspend fun addOption(name: String, imageUrl: String, questionId: Int)
    suspend fun deleteOption(option: Option)
}