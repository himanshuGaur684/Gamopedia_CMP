rootProject.name = "Gamopedia"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":core-database")
include(":core-network")

include(":search:ui")
include(":search:data")
include(":search:domain")

include(":game:ui")
include(":game:data")
include(":game:domain")

include(":favorite:ui")
include(":favorite:data")
include(":favorite:domain")

include(":common:ui")
include(":common:data")
include(":common:domain")


