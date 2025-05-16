package gaur.himanshu.coreNetwork.model.gameDetails

import kotlinx.serialization.Serializable

@Serializable

data class EsrbRatingDTO(
    val id: Int,
    val name: String,
    val slug: String
)