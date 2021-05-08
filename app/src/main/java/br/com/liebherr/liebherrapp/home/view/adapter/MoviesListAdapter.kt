package br.com.liebherr.liebherrapp.home.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import br.com.liebherr.liebherrapp.R
import br.com.liebherr.liebherrapp.databinding.LayoutMoviesListItemBinding
import br.com.liebherr.liebherrapp.model.Movie

class MoviesListAdapter(private val list: List<Movie>) : RecyclerView.Adapter<MovieViewHolder>() {

    lateinit var binding: LayoutMoviesListItemBinding
    val selectedMovie = MutableLiveData<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false) as LayoutMoviesListItemBinding

        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = list[position]

        holder.apply {
            bind(item)

            itemView.run {
                setOnClickListener { selectedMovie.value = item }
            }
        }
    }

    override fun getItemCount(): Int = list.count()

    override fun getItemViewType(position: Int): Int = R.layout.layout_movies_list_item
}
