package gaur.himanshu.game.domain.di

import gaur.himanshu.game.domain.useCases.DeleteUseCase
import gaur.himanshu.game.domain.useCases.GetGameDetailsUseCase
import gaur.himanshu.game.domain.useCases.GetGamesUseCase
import gaur.himanshu.game.domain.useCases.SaveGameUseCase
import org.koin.dsl.module

fun getGameDomainModule() = module{
    factory { GetGamesUseCase(gameRepository = get()) }
    factory { GetGameDetailsUseCase(gameRepository = get()) }
    factory { SaveGameUseCase(gameRepository = get()) }
    factory { DeleteUseCase(gameRepository = get()) }
}