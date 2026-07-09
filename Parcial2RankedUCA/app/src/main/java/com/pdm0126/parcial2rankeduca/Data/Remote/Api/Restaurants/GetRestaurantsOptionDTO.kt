package com.pdm0126.parcial2rankeduca.Data.Remote.Api.Restaurants

import com.pdm0126.parcial2rankeduca.Model.RestaurantOption
import kotlinx.serialization.Serializable

@Serializable
data class RestaurantsOptionDTO(
    val id: Int,
    val name: String,
    val imageUrl: String?,
    val votes: Int
)
fun RestaurantsOptionDTO.toModel(): RestaurantOption{
    return RestaurantOption (
        id = id,
        name = name,
        imageUrl = imageUrl,
        votos = votes
    )
}
