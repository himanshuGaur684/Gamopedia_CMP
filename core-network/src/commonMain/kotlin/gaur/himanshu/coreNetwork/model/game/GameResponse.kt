package gaur.himanshu.coreNetwork.model.game

import kotlinx.serialization.Serializable

@Serializable
data class GameResponse(
    val results: List<Result>,
)