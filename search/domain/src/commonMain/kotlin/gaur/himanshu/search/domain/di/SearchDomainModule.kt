package gaur.himanshu.search.domain.di

import gaur.himanshu.search.domain.useCases.SearchGamesUseCase
import org.koin.dsl.module

fun getSearchDomainModule() = module {
    factory { SearchGamesUseCase(searchRepository = get()) }
}