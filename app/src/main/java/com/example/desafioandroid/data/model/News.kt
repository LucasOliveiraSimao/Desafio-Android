package com.example.desafioandroid.data.model

import com.example.desafioandroid.data.model.Feed
import com.example.desafioandroid.data.model.Item
import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("feed")
    val feed: Feed,
    @SerializedName("items")
    val items: Collection<Item>,
    @SerializedName("status")
    val status: String
)