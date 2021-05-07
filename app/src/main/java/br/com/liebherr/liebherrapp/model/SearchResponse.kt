package br.com.liebherr.liebherrapp.model

import com.google.gson.annotations.SerializedName

class SearchResponse(@SerializedName("Search") val moviesList: List<Movie>)