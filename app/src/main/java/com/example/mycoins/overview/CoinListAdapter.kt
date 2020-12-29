package com.example.mycoins.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mycoins.databinding.LinearViewItemBinding
import com.example.mycoins.network.Coin

class CoinListAdapter : ListAdapter<Coin, CoinListAdapter.CoinViewHolder>(DiffCallBack) {
    class CoinViewHolder(private var binding : LinearViewItemBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(coin: Coin){
            binding.coin = coin
            binding.executePendingBindings()
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Coin>() {
        override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        return CoinViewHolder(LinearViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = getItem(position)
        holder.bind(coin)
    }

}