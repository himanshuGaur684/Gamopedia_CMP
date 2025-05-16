package gaur.himanshu.coreNetwork.di

import gaur.himanshu.coreNetwork.apiService.ApiService
import gaur.himanshu.coreNetwork.client.KtorClient
import org.koin.dsl.module

fun getCoreNetworkModule() = module {
    single { ApiService(httpClient = KtorClient.getInstance()) }
}