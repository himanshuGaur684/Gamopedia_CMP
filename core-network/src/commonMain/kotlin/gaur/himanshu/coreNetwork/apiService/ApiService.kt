package gaur.himanshu.coreNetwork.apiService

import gaur.himanshu.coreNetwork.model.game.GameResponse
import gaur.himanshu.coreNetwork.model.gameDetails.GameDetailsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService(
    val httpClient: HttpClient
) {

    // https://api.rawg.io/api/games?key=1abb1867f52548a4aa9f54dd4946af2f

    suspend fun getGames(): Result<GameResponse> {
        return try {
            val response = httpClient.get("api/games") {
                url {
                    parameter("key", "1abb1867f52548a4aa9f54dd4946af2f")
                }
            }.body<GameResponse>()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }


    suspend fun search(q: String): Result<GameResponse> {
        return try {
            val response = httpClient.get("api/games") {
                url {
                    parameter("key", "1abb1867f52548a4aa9f54dd4946af2f")
                    parameter("search", q)
                }
            }.body<GameResponse>()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // https://api.rawg.io/api/games/4200?key=1abb1867f52548a4aa9f54dd4946af2f

    suspend fun getDetails(id: Int): Result<GameDetailsResponse> {
        return try {
            val response = httpClient.get("api/games/${id}") {
                url {
                    parameter("key", "1abb1867f52548a4aa9f54dd4946af2f")
                }
            }.body<GameDetailsResponse>()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }

    }


}