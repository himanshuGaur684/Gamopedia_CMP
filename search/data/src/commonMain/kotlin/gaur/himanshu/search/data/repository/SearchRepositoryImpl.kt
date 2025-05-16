package gaur.himanshu.search.data.repository

import gaur.himanshu.common.data.mappers.toDomainListOfGames
import gaur.himanshu.common.domain.model.Game
import gaur.himanshu.coreNetwork.apiService.ApiService
import gaur.himanshu.search.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val apiService: ApiService
) : SearchRepository {

    override suspend fun search(q: String): Result<List<Game>> {
        return try {
            val response = apiService.search(q)
            val data = response.getOrThrow().results.toDomainListOfGames()
            Result.success(data)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}