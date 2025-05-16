package gaur.himanshu.favorite.data.di

import gaur.himanshu.coreDatabase.AppDatabase
import gaur.himanshu.favorite.data.repository.FavoriteRepoImpl
import gaur.himanshu.favorite.domain.repository.FavoriteRepository
import org.koin.core.module.Module
import org.koin.dsl.module

fun getFavoriteDataModule() : Module{
    return module {
        factory<FavoriteRepository> { FavoriteRepoImpl(get<AppDatabase>()) }
    }
}