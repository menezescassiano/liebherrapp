package br.com.liebherr.liebherrapp.repository

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceAPI {

    @GET("?apikey=a87c387")
    suspend fun getMovies(@Query("s") movie: String): ResponseBody
}