package br.com.liebherr.liebherrapp.usecase

import br.com.liebherr.liebherrapp.model.MovieDetailsResponse
import br.com.liebherr.liebherrapp.repository.MoviesRepository

class GetMovieDetailsUseCase(val repository: MoviesRepository) {

    suspend fun invoke(movieId: String): MovieDetailsResponse = repository.getMovieDetails(movieId)
}