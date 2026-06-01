package com.pdm0126.parcial2rankeduca.Data.Repository

import com.pdm0126.parcial2rankeduca.Data.Restaurants.PostRestaurantsVoteDTO
import com.pdm0126.parcial2rankeduca.Model.RestaurantOptions


class RestaurantApiRepository: RestaurantRepository {
    override suspend fun getRestaurantOptions(): Result<List<RestaurantOptions>> {
        try{

        }catch(e: Exception){
            
        }
    }

    override suspend fun postRestaurantVote(id: Int): Result<PostRestaurantsVoteDTO> {
        TODO("Not yet implemented")
    }
}