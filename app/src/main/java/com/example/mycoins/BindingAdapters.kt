package com.example.mycoins

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mycoins.network.Coin
import com.example.mycoins.network.CoinGeckoAPIStatus
import com.example.mycoins.overview.CoinListAdapter

// Binding function to provide item from a List<Cocktail> to a RecyclerView
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, coinList: List<Coin>?){
    val adapter = recyclerView.adapter as CoinListAdapter
    adapter.submitList(coinList)
}

// Binding function to provide image from URL to an ImageView
@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imgUrl:String?){
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imageView)
    }
}

// Binding function to handle display of animation or error image
@BindingAdapter("cocktailApiStatus")
fun bindStatus(statusImgView : ImageView, status: CoinGeckoAPIStatus?){
    when(status){
        CoinGeckoAPIStatus.LOADING -> {
            statusImgView.visibility  = View.VISIBLE
            statusImgView.setImageResource(R.drawable.loading_animation)
        }
        CoinGeckoAPIStatus.ERROR -> {
            statusImgView.visibility = View.VISIBLE
            statusImgView.setImageResource(R.drawable.ic_connection_error)
        }
        CoinGeckoAPIStatus.DONE-> statusImgView.visibility = View.GONE
    }
}