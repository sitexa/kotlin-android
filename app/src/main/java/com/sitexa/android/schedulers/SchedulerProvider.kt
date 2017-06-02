package com.sitexa.android.schedulers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Provides different types of schedulers.
 */
class SchedulerProvider private constructor() : ISchedulerProvider {

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    companion object {
        val instance: SchedulerProvider = SchedulerProvider()
    }
}
