package com.pdm0126.parcial2rankeduca.Data.Restaurants

import com.pdm0126.parcial2rankeduca.Model.RestaurantOptions
import kotlinx.serialization.Serializable

@Serializable
data class RestaurantsOptionDTO(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val votos: Int
)
fun RestaurantsOptionDTO.toModel(): RestaurantOptions{
    return RestaurantOptions (
        id = id,
        name = name,
        imageUrl = imageUrl,
        votos = votos
    )
}
