package br.com.liebherr.liebherrapp.repository

import br.com.liebherr.liebherrapp.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceAPI {

    @GET("?apikey=a87c387")
    suspend fun getMovies(@Query("s") movie: String): SearchResponse
}