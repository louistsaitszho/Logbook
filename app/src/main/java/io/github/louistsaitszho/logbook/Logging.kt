package io.github.louistsaitszho.logbook

import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.MESSAGE
import timber.log.Timber

//The 1 true king: Timber
fun getTree(): Timber.Tree = if (BuildConfig.DEBUG) Timber.DebugTree() else TODO("need another type of tree")

//TODO crashlytics log

//All the other libraries's interface on logging -> map to timber
val koinTimberLogger = object : Logger() {
    val TAG = "Koin"
    override fun log(level: Level, msg: MESSAGE) {
        Timber.tag(TAG).apply {
            when (level) {
                Level.DEBUG -> this.d(msg)
                Level.INFO -> this.i(msg)
                Level.ERROR -> this.e(msg)
            }
        }
    }
}