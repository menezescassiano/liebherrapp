package br.com.liebherr.liebherrapp.usecase

import br.com.liebherr.liebherrapp.model.SearchResponse
import br.com.liebherr.liebherrapp.repository.MoviesRepository

class GetMoviesUseCase(val repository: MoviesRepository) {

    suspend fun invoke(): SearchResponse = repository.getMovies()
}