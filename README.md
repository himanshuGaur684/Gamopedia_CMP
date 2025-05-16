# 🎮 Gamopedia

**Gamopedia** is a modern, modular Android application built entirely with **Jetpack Compose** and **Kotlin**, designed to explore games, search for them, and manage favorites. The app is architected using **MVVM + Clean Architecture**, supports **offline caching with SQLDelight**, and leverages **Ktor** for networking and **Koin** for dependency injection.

---

## 🧱 Project Structure

Gamopedia uses **modularization** for better scalability, testability, and maintainability. It follows **feature-based + layer-wise** modular architecture.

```
com.gamopedia
├── app # Application entry point and DI setup
│
├── core
│ ├── core-network # Handles Ktor client configuration and API services
│ └── core-database # SQLDelight database setup and DAOs
│
├── common # Shared resources: UI components, utilities, extensions
│
├── feature
│ ├── search # Search games by name or keyword
│ ├── game # Game dashboard and game details
│ └── favorite # List of all favorited (cached) games
```

---

## 📦 Tech Stack

| Category               | Tech Used                  |
|------------------------|----------------------------|
| Language               | Kotlin                     |
| UI                     | Jetpack Compose            |
| Architecture           | MVVM + Clean Architecture  |
| Networking             | Ktor Client                |
| Caching/DB             | SQLDelight                 |
| Dependency Injection   | Koin                       |
| Navigation             | Jetpack Navigation Compose |
| Concurrency            | Kotlin Coroutines + Flow   |
| Modularization         | Feature + Layer-wise       |

---

## ⚙️ Core Modules

### `core-network`
- Sets up **Ktor Client** with interceptors, logging, timeouts, and response parsing.
- Handles network API communication.
- Exposes remote data source abstractions to features.

### `core-database`
- Sets up **SQLDelight** for type-safe local database handling.
- Exposes DAOs and shared database schema.

---

## 🧰 Common Module

The `common` module provides:
- Shared **UI elements** (buttons, text styles, components)
- **Constants**, utility functions, resource helpers
- Common **navigation** definitions (if used across modules)

---

## 📂 Feature Modules

### 🔍 `feature-search`
- Allows users to search games using remote data from the Ktor API.
- Exposes a composable screen and ViewModel.

### 🕹️ `feature-game`
- Displays a **game dashboard** with popular and trending games.
- Includes **game detail screen** with more info and favorite button.

### ⭐ `feature-favorite`
- Shows all cached (favorited) games from local SQLDelight DB.
- Works offline and updates in real-time via `Flow`.

---

## 🧠 Architecture

Each feature module follows **layered Clean Architecture**:
```
feature-x
├── data # DTOs, Repository Implementation, Data Sources (Remote/Local)
├── domain # UseCases, Repository Interfaces, Models
└── presentation # ViewModels, Composables, Events/States
```

```
User Action
    ↓
presentation
(ViewModel, Composables, Events/States)
    ↓
domain
(UseCase → Repository Interface → Domain Models)
    ↓
data
(Repository Implementation → DTOs, Mappers, Data Sources)
    ↓
core
(core-network with Ktor / core-database with SQLDelight)



This separation ensures testability, scalability, and easy debugging.
```
---

## 📍 Navigation

- Uses **Jetpack Navigation Compose**.
- Feature modules define their own navigation graphs.
- Shared navigation routes/types are placed in the `common` module (if needed).

---

## 🔄 Caching with SQLDelight

- **SQLDelight** enables type-safe caching of game data.
- Favorite games are stored locally and observed using **Flow**.
- Cached data is used in the **Favorites** feature and game details.

---

## 🧪 Dependency Injection - Koin

**Koin** is used as the DI framework across all modules.

- Each module declares its own `KoinModule.kt` for scoping.
- Shared Koin setup is initialized in the `app` module:
```kotlin
class GamopediaApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GamopediaApp)
            modules(
                coreNetworkModule,
                coreDatabaseModule,
                commonModule,
                searchModule,
                gameModule,
                favoriteModule
            )
        }
    }
}


