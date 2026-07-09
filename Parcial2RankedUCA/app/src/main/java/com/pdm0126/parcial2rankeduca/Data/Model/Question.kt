package com.pdm0126.parcial2rankeduca.Data.Model

import com.pdm0126.parcial2rankeduca.Data.Database.Entities.QuestionEntity

data class Question(
    val id: Int= 0,
    val title:String,
    val optionCount: Int
)

fun Question.toEntity(): QuestionEntity {
    return QuestionEntity(
            id=id,
            title=title
    )
}