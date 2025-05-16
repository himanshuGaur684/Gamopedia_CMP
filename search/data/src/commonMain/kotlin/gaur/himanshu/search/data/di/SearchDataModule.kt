package gaur.himanshu.search.data.di

import gaur.himanshu.search.data.repository.SearchRepositoryImpl
import gaur.himanshu.search.domain.repository.SearchRepository
import org.koin.dsl.module

fun getSearchDataModule() = module {
    factory<SearchRepository> { SearchRepositoryImpl(apiService = get()) }
}