package br.com.liebherr.liebherrapp.home.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.liebherr.liebherrapp.R
import br.com.liebherr.liebherrapp.databinding.FragmentMoviesListBinding
import br.com.liebherr.liebherrapp.extension.activityViewModel
import br.com.liebherr.liebherrapp.extension.observe
import br.com.liebherr.liebherrapp.home.view.adapter.MoviesListAdapter
import br.com.liebherr.liebherrapp.home.viewmodel.MainViewModel
import br.com.liebherr.liebherrapp.home.viewmodel.MoviesListViewModel
import br.com.liebherr.liebherrapp.model.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesListFragment : Fragment() {

    lateinit var binding: FragmentMoviesListBinding
    private val viewModel: MoviesListViewModel by viewModel()
    private val flowViewModel: MainViewModel by activityViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies_list, container, false)

        viewModel.apply {
            binding.progressBar.visibility = View.VISIBLE
            observe(onMoviesSuccessResponse) {
                binding.progressBar.visibility = View.GONE
                it?.let {
                    setRecyclerView(it)
                }
            }

            lifecycle.addObserver(this)
        }

        return binding.root
    }

    private fun setRecyclerView(list: List<Movie>) {
        val listAdapter = MoviesListAdapter(list)
        binding.moviesRecyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
            listAdapter.apply {
                observe(selectedMovie) {
                    it?.let {
                        flowViewModel.selectedMovie = it.imdbID
                        flowViewModel.navigate(MainViewModel.Navigation.MovieDetails)
                    }
                }
            }
        }
    }

}