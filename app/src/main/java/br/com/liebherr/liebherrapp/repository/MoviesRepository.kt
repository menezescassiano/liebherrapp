package br.com.liebherr.liebherrapp.repository

import okhttp3.ResponseBody

class MoviesRepository(private val service: ServiceAPI) {

    suspend fun getMovies(): ResponseBody = service.getMovies("batman")

}