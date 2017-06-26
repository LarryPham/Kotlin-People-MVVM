package com.capstar.apps.people_mvvm.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Location(@SerializedName("street") val street: String, @SerializedName("city") val city: String,
                    @SerializedName("state") val state: String, @SerializedName("zip") val zip: String): Serializable
