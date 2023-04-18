package dev.renett.soulnotes.data

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dev.renett.soulnotes.database.SoulNotesDatabase

actual class DatabaseDriverFactory(private val context: Context) {

    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(SoulNotesDatabase.Schema, context, "soulnotes.db")
    }
}


// оставляю пасхалку - странно но нужно было соблюсти вложеность пакетов чтобы инстанс бд был сгенерирован
// https://stackoverflow.com/questions/65035103/sqldelight-database-schema-not-generated


// аааа ладно я тупая тут в гайде и написано СОЗДАТЬ ПЭКЭДЖ В commonMain с той же структурой
// https://kotlinlang.org/docs/multiplatform-mobile-ktor-sqldelight.html#generate-the-database-api