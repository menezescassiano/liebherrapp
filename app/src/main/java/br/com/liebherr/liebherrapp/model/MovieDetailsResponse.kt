package br.com.liebherr.liebherrapp.model

import com.google.gson.annotations.SerializedName

class MovieDetailsResponse(
    @SerializedName("Title") val title: String,
    @SerializedName("Released") val released: String,
    @SerializedName("Runtime") val runtime: String,
    @SerializedName("Plot") val plot: String,
    @SerializedName("Poster") val poster: String
)
