package com.pdm0126.parcial2rankeduca.Data.Repository

import com.pdm0126.parcial2rankeduca.Data.Remote.Api.Restaurants.PostRestaurantsVoteDTO
import com.pdm0126.parcial2rankeduca.Model.RestaurantOption

interface RestaurantRepository {
    suspend fun getRestaurantOptions(): Result<List<RestaurantOption>>
    suspend fun postRestaurantVote(id:Int): Result<PostRestaurantsVoteDTO>
}