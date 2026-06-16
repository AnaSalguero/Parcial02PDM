package com.pdm0126.parcial2rankeduca.Data.Database.Entities

import androidx.room.Embedded
import androidx.room.Relation
import com.pdm0126.parcial2rankeduca.Data.Model.Question

data class QuestionWithOptions(
    @Embedded val question: QuestionEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "questionId"
    )
    val options: List<OptionEntity>
)

fun QuestionWithOptions.toModel(): Question {
    return Question(
        id = question.id,
        title = question.title,
        optionCount = options.size,
    )
}
