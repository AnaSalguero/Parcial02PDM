package com.pdm0126.parcial2rankeduca.Data.Repository

import com.pdm0126.parcial2rankeduca.Data.Database.Dao.OptionDao
import com.pdm0126.parcial2rankeduca.Data.Database.Dao.QuestionDao
import com.pdm0126.parcial2rankeduca.Data.Database.Entities.toModel
import com.pdm0126.parcial2rankeduca.Data.Model.Option
import com.pdm0126.parcial2rankeduca.Data.Model.Question
import com.pdm0126.parcial2rankeduca.Data.Remote.Api.KtorClient
import com.pdm0126.parcial2rankeduca.Data.Remote.Api.Option.OptionDto
import com.pdm0126.parcial2rankeduca.Data.Remote.Api.Question.GetQuestionDto
import com.pdm0126.parcial2rankeduca.Data.Remote.Api.Question.toEntity
import com.pdm0126.parcial2rankeduca.Data.Remote.Api.Option.toEntity
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.collections.map

class QuestionOfflineFirstRepositoryImpl(
    private val daoQ: QuestionDao,
    private val daoO: OptionDao
) : QuestionOfflineFirstRepository {

    override fun getQuestions(): Flow<List<Question>> =
        daoQ.getQuestionsWithOptions()
            .map { list ->
                list.map { it.toModel() }
            }


    override fun getOptions(questionId: Int): Flow<List<Option>> =
        daoO.getOptionsForQuestion(questionId)
            .map { entities ->
                entities.map { it.toModel() }
            }


    override suspend fun refresh() {

        val questions = fetchQuestions()

        daoQ.updateQuestions(
            questions.map {
                it.toEntity()
            }
        )

        val options = fetchOptions()

        daoO.updateOption(
            options.map {
                it.toEntity()
            }
        )
    }
    override suspend fun createQuestion(text: String) {

        KtorClient.client.post("questions") {
            setBody(
                mapOf(
                    "title" to text
                )
            )
        }
        refresh()
    }

    override suspend fun deleteQuestion(id: Int) {
        KtorClient.client.delete("questions") {
            parameter("id",id)
        }
        refresh()
    }

    override suspend fun updateQuestion(id: Int, text: String) {
        TODO("Not yet implemented")
    }

    override suspend fun createOption(questionId: Int, value: String) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteOption(id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun updateOption(id: Int, value: String) {
        TODO("Not yet implemented")
    }

    private suspend fun fetchQuestions(): List<GetQuestionDto> =
        KtorClient.client.get("questions")
            .body()


    private suspend fun fetchOptions(): List<OptionDto> =
        KtorClient.client.get("options")
            .body()
}