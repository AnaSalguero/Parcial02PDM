package com.pdm0126.parcial2rankeduca.Data.Repository

import com.pdm0126.parcial2rankeduca.Data.Api.KtorClient
import com.pdm0126.parcial2rankeduca.Data.Restaurants.PostRestaurantsVoteDTO
import com.pdm0126.parcial2rankeduca.Data.Restaurants.RestaurantsOptionDTO
import com.pdm0126.parcial2rankeduca.Data.Restaurants.toModel
import com.pdm0126.parcial2rankeduca.Model.RestaurantOptions
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType


class RestaurantApiRepository: RestaurantRepository {
    override suspend fun getRestaurantOptions(): Result<List<RestaurantOptions>> {
        try{
            val response: List<RestaurantsOptionDTO> = KtorClient.client.get("options").body()

            return Result.success(response.map { resDTO -> resDTO.toModel() })
        }catch(e: Exception){
            return Result.failure(e)
        }
    }

    override suspend fun postRestaurantVote(idVote: Int): Result<PostRestaurantsVoteDTO> {
        try {
            val request = PostRestaurantsVoteDTO(
                id=idVote
            )

            val response: PostRestaurantsVoteDTO = KtorClient.client
                .post("vote") {
                    contentType(ContentType.Application.Json)
                    setBody(request)
                }
                .body()

            return Result.success(response)
        }catch (e: Exception){
            return Result.failure(e)
        }
    }
}