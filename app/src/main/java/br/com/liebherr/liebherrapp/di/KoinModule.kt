package br.com.liebherr.liebherrapp.di

import br.com.liebherr.liebherrapp.MainViewModel
import br.com.liebherr.liebherrapp.network.RetrofitClient
import br.com.liebherr.liebherrapp.repository.MoviesRepository
import br.com.liebherr.liebherrapp.usecase.GetMoviesUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val serviceModule = module {
    single { RetrofitClient.getApiService() }
}

private val repositoryModule = module {
    single { MoviesRepository(service = get()) }
}
/*private val resourceManager = module {
    single { ResourceManager(context = get()) }
}*/

private val useCases = module {
    single { GetMoviesUseCase(repository = get()) }
}

private val viewModelModule = module {
    viewModel { MainViewModel(getMoviesUseCase = get()) }
}

fun loadKoinModules() {
    org.koin.core.context.loadKoinModules(listOf(serviceModule, repositoryModule, useCases, viewModelModule))
}