package gaur.himanshu.gamopedia.di

import gaur.himanshu.coreDatabase.di.getCoreDatabaseModule
import gaur.himanshu.coreNetwork.di.getCoreNetworkModule
import gaur.himanshu.favorite.data.di.getFavoriteDataModule
import gaur.himanshu.favorite.domain.di.getFavoriteDomainModule
import gaur.himanshu.favorite.ui.di.getFavoriteUiModule
import gaur.himanshu.game.data.di.getGameDataModule
import gaur.himanshu.game.domain.di.getGameDomainModule
import gaur.himanshu.game.ui.di.getGameUiModule
import gaur.himanshu.search.data.di.getSearchDataModule
import gaur.himanshu.search.domain.di.getSearchDomainModule
import gaur.himanshu.search.ui.di.getSearchUiModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initKoin(koinApplication: ((KoinApplication) -> Unit)? = null) {
    startKoin {
        koinApplication?.invoke(this)
        modules(
            getCoreNetworkModule(),
            getGameDataModule(),
            getGameDomainModule(),
            getGameUiModule(),
            getSearchDataModule(),
            getSearchDomainModule(),
            getSearchUiModule(),
            getCoreDatabaseModule(),
            getFavoriteDataModule(),
            getFavoriteDomainModule(),
            getFavoriteUiModule()
        )
    }
}