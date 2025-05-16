package gaur.himanshu.favorite.domain.di

import gaur.himanshu.favorite.domain.useCases.DeleteUseCase
import gaur.himanshu.favorite.domain.useCases.GetAllLocalCahcedGamesUseCase
import gaur.himanshu.favorite.domain.useCases.UpsertUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun getFavoriteDomainModule(): Module {
    return module {
        factory { DeleteUseCase(get()) }
        factory { GetAllLocalCahcedGamesUseCase(get()) }
        factory { UpsertUseCase(get()) }
    }
}