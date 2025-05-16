package gaur.himanshu.coreNetwork.model.gameDetails

import kotlinx.serialization.Serializable

@Serializable
data class AddedByStatusDTO(
    val beaten: Int,
    val dropped: Int,
    val owned: Int,
    val playing: Int,
    val toplay: Int,
    val yet: Int
)