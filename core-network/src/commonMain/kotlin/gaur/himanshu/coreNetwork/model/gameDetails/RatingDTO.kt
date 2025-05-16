package gaur.himanshu.coreNetwork.model.gameDetails

import kotlinx.serialization.Serializable

@Serializable

data class RatingDTO(
    val count: Int,
    val id: Int,
    val percent: Double,
    val title: String
)