package gaur.himanshu.favorite.domain.useCases

import gaur.himanshu.favorite.domain.repository.FavoriteRepository

class DeleteUseCase(private val favoriteRepository: FavoriteRepository) {

    suspend operator fun invoke(id: Int) = favoriteRepository.delete(id)

}