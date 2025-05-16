package gaur.himanshu.favorite.domain.useCases

import gaur.himanshu.favorite.domain.repository.FavoriteRepository

class GetAllLocalCahcedGamesUseCase(private val favoriteRepository: FavoriteRepository) {

    operator fun invoke() = favoriteRepository.getAllGames()

}