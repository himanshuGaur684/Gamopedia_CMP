package gaur.himanshu.coreNetwork.model.gameDetails

import kotlinx.serialization.Serializable

@Serializable

data class PlatformXDTO(
    val platform: PlatformXXDTO,
    val released_at: String?,
)