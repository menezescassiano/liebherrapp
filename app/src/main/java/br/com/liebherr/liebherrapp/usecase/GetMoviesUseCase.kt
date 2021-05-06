package br.com.liebherr.liebherrapp.usecase

import br.com.liebherr.liebherrapp.repository.MoviesRepository
import okhttp3.ResponseBody

class GetMoviesUseCase(val repository: MoviesRepository) {

    suspend fun invoke(): ResponseBody = repository.getMovies()
}