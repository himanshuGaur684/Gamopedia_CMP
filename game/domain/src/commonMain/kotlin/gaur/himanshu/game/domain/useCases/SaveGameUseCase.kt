package gaur.himanshu.game.domain.useCases

import gaur.himanshu.game.domain.repository.GameRepository

class SaveGameUseCase(private val gameRepository: GameRepository) {
    suspend  operator fun invoke(id: Int, image: String, name: String) = gameRepository.save(id, image, name)
}