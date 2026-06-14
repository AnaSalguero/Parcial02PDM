package com.pdm0126.parcial2rankeduca.Data.Repository

import com.pdm0126.parcial2rankeduca.Data.Database.Dao.OptionDao
import com.pdm0126.parcial2rankeduca.Data.Database.Entities.toEntity
import com.pdm0126.parcial2rankeduca.Data.Database.Entities.toModel
import com.pdm0126.parcial2rankeduca.Data.Model.Option
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OptionRepositoryImpl (
    private val optionDao: OptionDao
) : OptionRepository{
    override fun getOptions(): Flow<List<Option>> {
        return optionDao.getAllOptions(). map { entities ->
            entities.map { it.toModel() }
        }
    }

    override suspend fun addOption(option: Option) {
        optionDao.insertOption(option.toEntity())
    }

    override suspend fun deleteOption(option: Option) {
        optionDao.deleteOption(option.toEntity())
    }
}