package br.com.liebherr.liebherrapp.home.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.liebherr.liebherrapp.R
import br.com.liebherr.liebherrapp.databinding.FragmentMovieDetailsBinding
import br.com.liebherr.liebherrapp.extension.activityViewModel
import br.com.liebherr.liebherrapp.extension.observe
import br.com.liebherr.liebherrapp.home.viewmodel.MainViewModel
import br.com.liebherr.liebherrapp.home.viewmodel.MovieDetailsViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsFragment : Fragment() {

    private val flowViewModel: MainViewModel by activityViewModel()
    private val viewModel: MovieDetailsViewModel by viewModel()

    lateinit var binding: FragmentMovieDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_details, container, false)

        binding.progressBar.visibility = View.VISIBLE
        viewModel.getMovieDetails(flowViewModel.selectedMovie)
        viewModel.apply {
            observe(onMovieDetailsResponse) {
                binding.progressBar.visibility = View.GONE
                it?.let {
                    binding.movieTitle.text = it.title
                    binding.released.text = it.released
                    setImageUrl(it.poster)
                }
            }
        }
        return binding.root
    }

    private fun setImageUrl(plot: String) {
        val imageView = binding.imageView
        val placeHolder = R.drawable.placeholder

        plot.run {
            Glide.with(imageView.context).load(this)
                .apply(RequestOptions().placeholder(placeHolder))
                .into(imageView)
        }
    }

}