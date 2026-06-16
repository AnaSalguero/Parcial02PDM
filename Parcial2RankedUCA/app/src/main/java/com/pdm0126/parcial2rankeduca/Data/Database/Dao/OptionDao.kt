package com.pdm0126.parcial2rankeduca.Data.Database.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pdm0126.parcial2rankeduca.Data.Database.Entities.OptionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OptionDao {

    @Query("SELECT * FROM options WHERE questionId = :questionId")
    fun getOptionsForQuestion(questionId: Int): Flow<List<OptionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOption(option: OptionEntity)

    @Delete
    suspend fun deleteOption(option: OptionEntity)
}