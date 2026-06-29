package com.pdm0126.parcial2rankeduca.Data.Database.Entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.pdm0126.parcial2rankeduca.Data.Model.Option

@Entity(
    tableName = "options",
    foreignKeys = [
        ForeignKey(
            entity = QuestionEntity::class,
            parentColumns = ["id"],
            childColumns = ["questionId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("questionId")]
)
data class OptionEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val value:String,
    val imageUrl: String?= null,
    val questionId: Int,
)

fun OptionEntity.toModel(): Option {
    return Option (
        id=id,
        value = value,
        imageUrl = imageUrl,
        questionId = questionId,
    )
}


