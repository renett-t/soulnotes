pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SoulNotes"

include(":shared")
include(":shared:main:common")
include(":shared:main:music")
include(":shared:main:podcasts")

include(":SoulNotes_Android")
include(":SoulNotes_Android:common")
include(":SoulNotes_Android:common")
include(":SoulNotes_Android:music")
include(":SoulNotes_Android:player")
