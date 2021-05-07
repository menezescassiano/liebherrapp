package br.com.liebherr.liebherrapp.home.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import br.com.liebherr.liebherrapp.R
import br.com.liebherr.liebherrapp.extension.defaultNavController
import br.com.liebherr.liebherrapp.extension.defaultNavigate
import br.com.liebherr.liebherrapp.extension.observe
import br.com.liebherr.liebherrapp.home.viewmodel.MainViewModel
import br.com.liebherr.liebherrapp.home.viewmodel.MainViewModel.Navigation.MovieDetails
import br.com.liebherr.liebherrapp.home.viewmodel.MainViewModel.Navigation.MoviesList
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.apply {
            observe(navigationEvent) { it?.let { navigateTo(it) } }
        }

        setContentView(R.layout.activity_navigation)
        navController = defaultNavController(R.navigation.navigation_movies)

    }

    private fun navigateTo(navigation: MainViewModel.Navigation) {
        when (navigation) {
            MoviesList -> navController.defaultNavigate(R.id.frag_movies_list)
            MovieDetails -> navController.defaultNavigate(R.id.frag_movie_details)
            //ClosePendingOrdersFlow -> finish()
        }
    }
}