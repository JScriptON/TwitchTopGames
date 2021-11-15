package com.development.twitchtopgames.model

import com.google.gson.annotations.SerializedName

data class Item(
     @SerializedName("top")
     val top: List<Top>

)
