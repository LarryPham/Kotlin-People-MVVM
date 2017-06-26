package com.capstar.apps.people_mvvm.data

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PeopleFactory {
    private val BASE_URL = "http://api.randomuser.me/"
    val RANDOM_USER_URL = "http://api.randomuser.me/?results=10&nat=en"
    val PROJECT_URL = "https://github.com/erikcaffrey/People-MVVM"

    val service: PeopleService = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(PeopleService::class.java)
}