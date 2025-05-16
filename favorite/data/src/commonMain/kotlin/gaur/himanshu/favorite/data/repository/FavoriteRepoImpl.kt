package gaur.himanshu.favorite.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import gaur.himanshu.common.domain.model.Game
import gaur.himanshu.coreDatabase.AppDatabase
import gaur.himanshu.favorite.domain.repository.FavoriteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoriteRepoImpl(
    private val appDatabase: AppDatabase
) : FavoriteRepository {
    override fun getAllGames(): Flow<List<Game>> {
        return appDatabase.appDatabaseQueries
            .getAllGames()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map {
                it.map {
                    Game(
                        id = it.id.toInt(),
                        name = it.name,
                        imageUrl = it.image
                    )
                }
            }
    }

    override suspend fun upsert(id: Int, image: String, name: String) {
        appDatabase.appDatabaseQueries
            .upsert(id.toLong(), image, name)
    }

    override suspend fun delete(id: Int) {
        appDatabase.appDatabaseQueries
            .delete(id.toLong())
    }
}