package com.pdm0126.parcial2rankeduca.Data.Repository

import com.pdm0126.parcial2rankeduca.Data.Database.Dao.OptionDao
import com.pdm0126.parcial2rankeduca.Data.Database.Entities.toModel
import com.pdm0126.parcial2rankeduca.Data.Model.Option
import com.pdm0126.parcial2rankeduca.Data.Model.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OptionRepositoryImpl (
    private val optionDao: OptionDao
) : OptionRepository{
    override fun getOptions(questionId: Int): Flow<List<Option>> {
        return optionDao.getOptionsForQuestion(questionId).map { entities ->
            entities.map { it.toModel() }
        }
    }

    override suspend fun addOption(value: String, imageUrl: String, questionId: Int) {
        val option = Option(value = value, imageUrl = imageUrl, questionId = questionId)
        optionDao.insertOption(option.toEntity())
    }

    override suspend fun deleteOption(option: Option) {
        optionDao.deleteOption(option.toEntity())
    }

    override suspend fun updateOption(option: Option) {
        optionDao.updateOption(option.toEntity())
    }
}