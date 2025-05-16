package gaur.himanshu.common.data.mappers

import gaur.himanshu.common.domain.model.Game

fun List<gaur.himanshu.coreNetwork.model.game.Result>.toDomainListOfGames(): List<Game> = map {
    Game(
        id = it.id,
        name = it.name,
        imageUrl = it.background_image
    )
}