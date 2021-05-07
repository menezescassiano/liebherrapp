package br.com.liebherr.liebherrapp.repository

import br.com.liebherr.liebherrapp.model.MovieDetailsResponse
import br.com.liebherr.liebherrapp.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceAPI {

    companion object {
        const val API_KEY = "?apikey=a87c387"
    }

    @GET(API_KEY)
    suspend fun getMovies(@Query("s") movie: String): SearchResponse

    @GET(API_KEY)
    suspend fun getMovieDetails(@Query("i") movieId: String): MovieDetailsResponse
}