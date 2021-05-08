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
import br.com.liebherr.liebherrapp.model.MovieDetailsResponse
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsFragment : Fragment() {

    private val flowViewModel: MainViewModel by activityViewModel()
    private val viewModel: MovieDetailsViewModel by viewModel()

    lateinit var binding: FragmentMovieDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_details, container, false)

        showProgressBar(true)

        setupViewModel()

        return binding.root
    }

    private fun showProgressBar(show: Boolean) {
        binding.progressBar.visibility = when {
            show -> View.VISIBLE
            else -> View.GONE
        }
    }

    private fun setupViewModel() {
        viewModel.apply {

            getMovieDetails(flowViewModel.selectedMovie)

            observe(onMovieDetailsResponse) {

                showProgressBar(false)

                it?.let {
                    setupUi(it)
                }
            }
        }
    }

    private fun setupUi(movieDetailsResponse: MovieDetailsResponse) {
        binding.run {
            toolBar.setOnClickListener {
                activity?.onBackPressed()
            }

            movieDetailsResponse.run {
                movieTitle.text = title
                releasedText.text = released
                runtimeText.text = runtime
                plotText.text = plot
                setImageUrl(poster)
            }
        }
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
