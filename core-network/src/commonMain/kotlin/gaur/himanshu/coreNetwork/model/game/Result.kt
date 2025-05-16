package gaur.himanshu.coreNetwork.model.game

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val background_image: String,
    val id: Int,
    val name: String,
)