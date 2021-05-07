package br.com.liebherr.liebherrapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Movie(
    @SerializedName("Title") val title: String,
    @SerializedName("Year") val year: String,
    @SerializedName("imdbID") val imdbID: String,
    @SerializedName("Type") val type: String,
    @SerializedName("Poster") val poster: String
) : Parcelable