package com.example.moneywellspent.choosecategory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moneywellspent.data.model.CategoryData
import com.example.moneywellspent.databinding.CategoryListItemBinding

class CategoryAdapter(val onItemClickListener: OnItemClickListener) :
    ListAdapter<CategoryData, CategoryViewHolder>(CategoryDataDiffUtils()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClickListener)
    }
}

class CategoryViewHolder(val binding: CategoryListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun from(parent: ViewGroup): CategoryViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = CategoryListItemBinding.inflate(inflater, parent, false)
            return CategoryViewHolder(binding)
        }
    }

    fun bind(category: CategoryData, clickListener: OnItemClickListener) {
        binding.category = category
        binding.clickListener = clickListener;
    }


}

class CategoryDataDiffUtils : DiffUtil.ItemCallback<CategoryData>() {
    override fun areItemsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean {
        return oldItem.category == newItem.category
    }

    override fun areContentsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean {
        return oldItem == newItem
    }

}

class OnItemClickListener(val clickListener: (category: CategoryData) -> Unit) {
    fun onClick(category: CategoryData) {
        clickListener(category)
    }

}