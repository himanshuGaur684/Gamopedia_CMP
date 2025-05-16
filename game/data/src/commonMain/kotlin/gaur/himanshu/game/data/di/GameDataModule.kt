package gaur.himanshu.game.data.di

import gaur.himanshu.game.data.repository.GameRepositoryImpl
import gaur.himanshu.game.domain.repository.GameRepository
import org.koin.dsl.module

fun getGameDataModule() = module {
    factory<GameRepository> { GameRepositoryImpl(apiService = get(), appDatabase = get()) }
}