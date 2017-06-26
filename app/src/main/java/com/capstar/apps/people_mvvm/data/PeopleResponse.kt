package com.capstar.apps.people_mvvm.data

import com.capstar.apps.people_mvvm.model.People
import com.google.gson.annotations.SerializedName

data class PeopleResponse(@SerializedName("results") val peopleList: MutableList<People>)