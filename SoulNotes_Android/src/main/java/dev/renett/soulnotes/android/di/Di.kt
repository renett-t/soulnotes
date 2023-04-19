package dev.renett.soulnotes.android.di

import android.content.Context
import dev.renett.soulnotes.di.AppScope
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
@AppScope
abstract class ApplicationComponent(
    @get:Provides val context: Context,
) {

}


interface ApplicationComponentProvider {
    val component: ApplicationComponent
}

val Context.applicationComponent
    get() = (applicationContext as ApplicationComponentProvider).component
