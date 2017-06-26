package com.capstar.apps.people_mvvm.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class People(@SerializedName("gender") val gender: String, @SerializedName("name") val name: Name,
                  @SerializedName("location") val location: Location, @SerializedName("email") val email: String,
                  @SerializedName("login") val userName: Login, @SerializedName("phone") val phone: String,
                  @SerializedName("cell") val cell: String, @SerializedName("picture") val picture: Picture) : Serializable {

    val hasEmail: Boolean
        get() = email != null && !email.isEmpty()
}