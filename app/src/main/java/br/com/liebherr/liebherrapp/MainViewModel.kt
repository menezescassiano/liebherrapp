package br.com.liebherr.liebherrapp

import androidx.lifecycle.ViewModel
import br.com.liebherr.liebherrapp.usecase.GetMoviesUseCase
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    fun getMovies() {

        viewModelScope.launch {
            getMoviesUseCase.invoke().also {
                println(it.toString())
            }
        }
    }

}