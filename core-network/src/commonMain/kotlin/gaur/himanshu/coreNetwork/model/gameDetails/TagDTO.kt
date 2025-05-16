package gaur.himanshu.coreNetwork.model.gameDetails

import kotlinx.serialization.Serializable

@Serializable

data class TagDTO(
    val games_count: Int,
    val id: Int,
    val image_background: String,
    val language: String,
    val name: String,
    val slug: String
)