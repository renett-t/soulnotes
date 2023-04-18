package dev.renett.soulnotes.data

import com.squareup.sqldelight.db.SqlDriver
import dev.renett.soulnotes.database.SoulNotesDatabase

// about expect & actual: https://kotlinlang.org/docs/multiplatform-connect-to-apis.html
expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

// https://kotlinlang.org/docs/multiplatform-mobile-ktor-sqldelight.html#implement-cache
internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = SoulNotesDatabase(databaseDriverFactory.createDriver())

    private val musicTrackQueries = database.musicTrackQueries
    private val soulNotesDatabaseQueries = database.soulNotesDatabaseQueries

    internal fun clearDatabase() {
//        musicTrackQueries.transaction {
//            musicTrackQueries.deleteAll()
//        }
    }
}