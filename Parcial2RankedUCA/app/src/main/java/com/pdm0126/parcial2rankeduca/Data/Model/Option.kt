package com.pdm0126.parcial2rankeduca.Data.Model

import com.pdm0126.parcial2rankeduca.Data.Database.Entities.OptionEntity

data class Option(
    val id: Int=0,
    val value: String,
    val imageUrl: String?=null,
    val questionId: Int = 0,
)
fun Option.toEntity(): OptionEntity {
    return OptionEntity (
        id=id,
        value = value,
        imageUrl = imageUrl,
        questionId = questionId,
    )
}
