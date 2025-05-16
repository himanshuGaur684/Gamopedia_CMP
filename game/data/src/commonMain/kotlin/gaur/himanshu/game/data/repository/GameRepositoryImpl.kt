package gaur.himanshu.game.data.repository

import gaur.himanshu.common.data.mappers.toDomainListOfGames
import gaur.himanshu.common.domain.model.Game
import gaur.himanshu.coreDatabase.AppDatabase
import gaur.himanshu.coreNetwork.apiService.ApiService
import gaur.himanshu.game.data.mappers.toDomainGameDetails
import gaur.himanshu.game.domain.model.GameDetails
import gaur.himanshu.game.domain.repository.GameRepository

class GameRepositoryImpl(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) : GameRepository {
    override suspend fun getGames(): Result<List<Game>> {
        val result = apiService.getGames()
        return if (result.isSuccess) {
            Result.success(result.getOrThrow().results.toDomainListOfGames())
        } else {
            Result.failure(result.exceptionOrNull()!!)
        }
    }

    override suspend fun getDetails(id: Int): Result<GameDetails> {
        val result = apiService.getDetails(id)
        return if (result.isSuccess) {
            Result.success(result.getOrThrow().toDomainGameDetails())
        } else {
            Result.failure(result.exceptionOrNull()!!)
        }
    }

    override suspend fun save(id: Int, image: String, name: String) {
        appDatabase.appDatabaseQueries
            .upsert(id.toLong(), image, name)
    }

    override suspend fun delete(id: Int) {
        appDatabase.appDatabaseQueries
            .delete(id.toLong())
    }
}