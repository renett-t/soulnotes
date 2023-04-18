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

include(":SoulNotes_Shared")
include(":SoulNotes_Shared:main:common")
include(":SoulNotes_Shared:main:music")
include(":SoulNotes_Shared:main:podcasts")

include(":SoulNotes_Android")
include(":SoulNotes_Android:common")
include(":SoulNotes_Android:common")
include(":SoulNotes_Android:music")
include(":SoulNotes_Android:player")
