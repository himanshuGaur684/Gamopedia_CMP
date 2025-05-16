package gaur.himanshu.favorite.ui.di

import gaur.himanshu.favorite.ui.FavoriteViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun getFavoriteUiModule(): Module{
    return module {
        viewModel { FavoriteViewModel(
            getAllLocalCahcedGamesUseCase = get(),
            deleteUseCase = get()
        ) }
    }
}