package br.com.liebherr.liebherrapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class SearchResponse(@SerializedName("Search") val moviesList: List<Movie>) : Parcelable