package gaur.himanshu.game.domain.repository

import gaur.himanshu.common.domain.model.Game
import gaur.himanshu.game.domain.model.GameDetails


interface GameRepository {

    suspend fun getGames(): Result<List<Game>>

    suspend fun getDetails(id: Int): Result<GameDetails>

    suspend fun save(id: Int, image: String, name: String)

    suspend fun delete(id: Int)

}