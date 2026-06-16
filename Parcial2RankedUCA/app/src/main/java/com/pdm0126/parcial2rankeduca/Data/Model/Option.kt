package com.pdm0126.parcial2rankeduca.Data.Model

import com.pdm0126.parcial2rankeduca.Data.Database.Entities.OptionEntity

data class Option(
    val id: Int=0,
    val name: String,
    val imageUrl: String,
    val questionId: Int = 0,
)
fun Option.toEntity(): OptionEntity {
    return OptionEntity (
        id=id,
        name = name,
        imageUrl = imageUrl,
        questionId = questionId,
    )
}
