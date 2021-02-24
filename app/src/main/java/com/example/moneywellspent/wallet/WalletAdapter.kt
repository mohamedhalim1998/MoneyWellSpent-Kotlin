package com.example.moneywellspent.wallet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moneywellspent.R
import com.example.moneywellspent.data.model.Wallet
import com.example.moneywellspent.databinding.WalletListItemBinding

class WalletsAdapter : ListAdapter<Wallet, WalletViewHolder>(WalletDiffUtils()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletViewHolder {
        return WalletViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: WalletViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class WalletViewHolder(private val binding: WalletListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun from(parent: ViewGroup): WalletViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = WalletListItemBinding.inflate(inflater, parent, false)
            return WalletViewHolder(binding)
        }
    }

    fun bind(wallet: Wallet) {
       binding.wallet = wallet
    }
}

class WalletDiffUtils : DiffUtil.ItemCallback<Wallet>() {
    override fun areItemsTheSame(oldItem: Wallet, newItem: Wallet): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Wallet, newItem: Wallet): Boolean {
        return oldItem == newItem
    }

}