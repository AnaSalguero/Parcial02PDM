package com.pdm0126.parcial2rankeduca.Data.Remote.Api.Option

import com.pdm0126.parcial2rankeduca.Data.Database.Entities.OptionEntity

data class OptionDto (
    val id: Int=0,
    val value: String,
    val imageUrl: String?=null,
    val questionId: Int = 0,
)

fun OptionDto.toEntity(): OptionEntity = OptionEntity(
    id=id,
    value = value,
    imageUrl = imageUrl,
    questionId = questionId
)