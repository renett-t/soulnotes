pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
    }
}

rootProject.name = "SoulNotes"

include(":SoulNotes_Shared")

include(":SoulNotes_Android")
include(":SoulNotes_Android:common")
include(":SoulNotes_Android:music")
include(":SoulNotes_Android:player")
