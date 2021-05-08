package br.com.liebherr.liebherrapp.di

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import br.com.liebherr.liebherrapp.home.viewmodel.MainViewModel
import br.com.liebherr.liebherrapp.home.viewmodel.MovieDetailsViewModel
import br.com.liebherr.liebherrapp.home.viewmodel.MoviesListViewModel
import br.com.liebherr.liebherrapp.network.RetrofitClient
import br.com.liebherr.liebherrapp.repository.MoviesRepository
import br.com.liebherr.liebherrapp.usecase.GetMovieDetailsUseCase
import br.com.liebherr.liebherrapp.usecase.GetMoviesUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val serviceModule = module {
    single { RetrofitClient.getApiService() }
}

private val repositoryModule = module {
    single { MoviesRepository(service = get()) }
}

private val useCases = module {
    single { GetMoviesUseCase(repository = get()) }
    single { GetMovieDetailsUseCase(repository = get()) }
}

private val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { MoviesListViewModel(getMoviesUseCase = get()) }
    viewModel { MovieDetailsViewModel(getMovieDetailsUseCase = get()) }
}

fun loadKoinModules() {
    org.koin.core.context.loadKoinModules(listOf(serviceModule, repositoryModule, useCases, viewModelModule))
}

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, expression: (T?) -> Unit) {
    liveData.observe(this, Observer(expression))
}
