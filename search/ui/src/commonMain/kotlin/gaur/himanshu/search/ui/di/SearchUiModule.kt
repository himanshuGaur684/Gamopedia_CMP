package gaur.himanshu.search.ui.di

import gaur.himanshu.search.ui.SearchViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun getSearchUiModule() = module {
    viewModel { SearchViewModel(searchGameUseCase = get()) }
}