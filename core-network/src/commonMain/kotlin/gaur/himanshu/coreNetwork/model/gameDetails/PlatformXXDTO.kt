package gaur.himanshu.coreNetwork.model.gameDetails

import kotlinx.serialization.Serializable

@Serializable

data class PlatformXXDTO(
    val games_count: Int?=0,
    val id: Int,
    val image_background: String,
    val name: String,
    val slug: String,
)