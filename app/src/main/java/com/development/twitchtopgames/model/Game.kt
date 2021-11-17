package com.development.twitchtopgames.model

import com.google.gson.annotations.SerializedName


data class Game(
    @SerializedName("_id")
    val id: Int,
    @SerializedName("localized_name")
    val name: String,
    val box: Box
)

