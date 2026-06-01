package com.pdm0126.parcial2rankeduca.Data.Repository

import com.pdm0126.parcial2rankeduca.Data.Restaurants.PostRestaurantsVoteDTO
import com.pdm0126.parcial2rankeduca.Model.RestaurantOptions

interface RestaurantRepository {
    suspend fun getRestaurantOptions(): Result<List<RestaurantOptions>>
    suspend fun postRestaurantVote(id:Int): Result<PostRestaurantsVoteDTO>
}