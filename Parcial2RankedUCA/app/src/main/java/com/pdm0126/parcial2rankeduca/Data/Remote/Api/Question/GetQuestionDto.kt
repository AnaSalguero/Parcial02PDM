package com.pdm0126.parcial2rankeduca.Data.Remote.Api.Question

import com.pdm0126.parcial2rankeduca.Data.Database.Entities.QuestionEntity

data class GetQuestionDto (
    val id: Int= 0,
    val title:String,
)

fun GetQuestionDto.toEntity() : QuestionEntity = QuestionEntity(
    id = id,
    title = title
)