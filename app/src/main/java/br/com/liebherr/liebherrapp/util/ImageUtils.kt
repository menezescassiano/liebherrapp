package br.com.liebherr.liebherrapp.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ImageUtils {

    companion object {
        fun setImageUrl(context: Context, imageView: ImageView, plot: String) {

            val circularProgressDrawable = CircularProgressDrawable(context)
            circularProgressDrawable.run {
                strokeWidth = 5f
                centerRadius = 30f
                start()
            }

            plot.run {
                Glide.with(context).load(this).apply(RequestOptions().placeholder(circularProgressDrawable)).into(imageView)
            }
        }
    }
}