package gaur.himanshu.coreDatabase.di

import app.cash.sqldelight.db.SqlDriver
import gaur.himanshu.coreDatabase.AppDatabase
import gaur.himanshu.coreDatabase.SqlDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun getCoreDatabaseModule(): Module {
    return module {
        single { SqlDriverFactory().getSqlDriver() }
        single { AppDatabase.invoke(get<SqlDriver>()) }

    }
}