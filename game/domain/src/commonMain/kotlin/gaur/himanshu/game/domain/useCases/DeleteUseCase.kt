package gaur.himanshu.game.domain.useCases

import gaur.himanshu.game.domain.repository.GameRepository

class DeleteUseCase (private val gameRepository: GameRepository) {

    suspend operator fun invoke(id:Int) = gameRepository.delete(id)

}