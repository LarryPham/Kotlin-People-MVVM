package com.capstar.apps.people_mvvm.viewmodel

import android.content.Context
import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.view.View
import com.capstar.apps.people_mvvm.PeopleApp
import com.capstar.apps.people_mvvm.R
import com.capstar.apps.people_mvvm.data.PeopleFactory
import com.capstar.apps.people_mvvm.data.PeopleResponse
import com.capstar.apps.people_mvvm.model.People
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import java.util.*


class PeopleViewModel(var context: Context): Observable() {
    var peopleProgress: ObservableInt
    var peopleRecycler: ObservableInt

    var peopleLabel: ObservableInt
    var messageLabel: ObservableField<String>

    var peopleList: MutableList<People> = arrayListOf()

    var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    init {
        peopleProgress = ObservableInt(View.GONE)
        peopleRecycler = ObservableInt(View.GONE)
        peopleLabel = ObservableInt(View.GONE)
        messageLabel = ObservableField(context.getString(R.string.default_loading_people))
    }

    fun onClickFabLoad(view: View) {
        initializeViews()
        fetchPeopleList()
    }

    fun initializeViews() {
        peopleLabel.set(View.GONE)
        peopleRecycler.set(View.GONE)
        peopleProgress.set(View.VISIBLE)
    }

    private fun fetchPeopleList() {
        val peopleApp = PeopleApp.create(appContext = context)
        val peopleService = peopleApp.peopleService

        val disposable = peopleService!!.fetchPeople(PeopleFactory.RANDOM_USER_URL).subscribeOn(peopleApp.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({ peopleProgress.set(View.GONE)
            peopleLabel.set(View.GONE)
            peopleRecycler.set(View.VISIBLE)
        }, {
            messageLabel.set(context.getString(R.string.error_loading_people))
            peopleProgress.set(View.GONE)
            peopleLabel.set(View.VISIBLE)
            peopleRecycler.set(View.GONE)
        })
        compositeDisposable!!.add(disposable)
    }

    private fun changePeopleDataSet(peoples: MutableList<People>) {
        peopleList.addAll(peoples)
        setChanged()
        notifyObservers()
    }

    private fun unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable!!.isDisposed) {
            compositeDisposable!!.dispose()
        }
    }

    fun reset() {
        unSubscribeFromObservable()
        compositeDisposable = null
    }
}