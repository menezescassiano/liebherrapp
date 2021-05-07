package br.com.liebherr.liebherrapp.repository

import br.com.liebherr.liebherrapp.model.SearchResponse

class MoviesRepository(private val service: ServiceAPI) {

    suspend fun getMovies(): SearchResponse = service.getMovies("batman")

}