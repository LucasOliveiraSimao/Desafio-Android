package com.example.desafioandroid.data.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("author")
    val author: String,
    @SerializedName("categories")
    val categories: List<String>,
    @SerializedName("content")
    val content: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("guid")
    val guid: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("pubDate")
    val pubDate: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String
)