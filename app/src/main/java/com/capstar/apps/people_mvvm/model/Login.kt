package com.capstar.apps.people_mvvm.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Login(@SerializedName("username") val username: String): Serializable