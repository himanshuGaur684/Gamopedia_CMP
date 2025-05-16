package gaur.himanshu.game.ui.di

import gaur.himanshu.game.ui.game.GameViewModel
import gaur.himanshu.game.ui.gameDetails.GameDetailsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun getGameUiModule() = module {
    viewModel { GameViewModel(getGameUseCase = get()) }
    viewModel { GameDetailsViewModel(
        getGameDetailsUseCase = get(),
        saveGameUseCase = get(),
        deleteUseCase = get(),
    ) }
}