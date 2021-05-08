package br.com.liebherr.liebherrapp.model

import com.google.gson.annotations.SerializedName

class Movie(
    @SerializedName("Title") val title: String,
    @SerializedName("imdbID") val imdbID: String
)
