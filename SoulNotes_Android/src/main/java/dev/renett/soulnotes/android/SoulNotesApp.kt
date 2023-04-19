package dev.renett.soulnotes.android

import android.app.Application
import dev.renett.soulnotes.android.di.ApplicationComponent
import dev.renett.soulnotes.android.di.ApplicationComponentProvider
import dev.renett.soulnotes.android.di.create

class SoulNotesApp : Application(), ApplicationComponentProvider {

    override val component: ApplicationComponent =
        ApplicationComponent::class.create(applicationContext)

    override fun onCreate() {
        super.onCreate()
    }


}