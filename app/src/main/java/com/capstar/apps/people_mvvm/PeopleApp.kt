package com.capstar.apps.people_mvvm

import android.app.Application
import android.content.Context

import com.capstar.apps.people_mvvm.data.PeopleFactory
import com.capstar.apps.people_mvvm.data.PeopleService

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class PeopleApp : Application() {

    var peopleService: PeopleService? = null
        get() {
            if (field == null) {
                this.peopleService = PeopleFactory.service
            }

            return field
        }

    private var scheduler: Scheduler? = null

    fun subscribeScheduler(): Scheduler? {
        if (scheduler == null) {
            scheduler = Schedulers.io()
        }

        return scheduler
    }

    fun setScheduler(scheduler: Scheduler) {
        this.scheduler = scheduler
    }

    companion object {

        private fun get(context: Context): PeopleApp {
            return context.applicationContext as PeopleApp
        }

        fun create(appContext: Context): PeopleApp {
            return get(appContext)
        }
    }
}
