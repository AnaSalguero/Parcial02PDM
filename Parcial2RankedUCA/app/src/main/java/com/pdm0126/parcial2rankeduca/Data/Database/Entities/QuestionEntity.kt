package com.pdm0126.parcial2rankeduca.Data.Database.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pdm0126.parcial2rankeduca.Data.Model.Question

@Entity(tableName = "questions")
data class QuestionEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
)

fun QuestionEntity.toModel(): Question {
    return Question(
        id = id,
        title = title,
        optionCount = 0,
    )
}
