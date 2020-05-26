package com.greate43.sk.optussenerio2.services.model

import com.google.gson.annotations.SerializedName

data class Photos (

    @SerializedName("albumId") val albumId : Int,
    @SerializedName("id") val id : Int,
    @SerializedName("title") val title : String,
    @SerializedName("url") val url : String,
    @SerializedName("thumbnailUrl") val thumbnailUrl : String
)