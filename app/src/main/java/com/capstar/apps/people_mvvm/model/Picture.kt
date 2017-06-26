package com.capstar.apps.people_mvvm.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Picture(@SerializedName("large") val large: String, @SerializedName("medium") val medium: String,@SerializedName("thumbnail") val thumbnail: String): Serializable