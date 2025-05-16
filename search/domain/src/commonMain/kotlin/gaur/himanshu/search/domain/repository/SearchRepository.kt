package gaur.himanshu.search.domain.repository

import gaur.himanshu.common.domain.model.Game

interface SearchRepository {

    suspend fun search(q: String): Result<List<Game>>

}