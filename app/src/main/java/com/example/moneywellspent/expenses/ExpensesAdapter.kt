package com.example.moneywellspent.expenses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moneywellspent.R
import com.example.moneywellspent.data.model.Expense
import com.example.moneywellspent.data.model.ExpenseCategory
import com.example.moneywellspent.databinding.ExpenseListItemBinding

class ExpensesAdapter : ListAdapter<Expense, ExpenseViewHolder>(ExpenseDiffUtils()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        return ExpenseViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class ExpenseViewHolder(private val binding: ExpenseListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun from(parent: ViewGroup): ExpenseViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ExpenseListItemBinding.inflate(inflater, parent, false)
            return ExpenseViewHolder(binding)
        }
    }

    fun bind(expense: Expense) {
        binding.expenseAmount.text = expense.amount.toString()
        binding.expenseCategory.text = expense.category.toString().capitalize()
        binding.expenseIcon.apply {
            when (expense.category) {
                ExpenseCategory.TRANSFER -> setImageResource(R.drawable.ic_transfer)
                ExpenseCategory.TRANSPORTATION -> setImageResource(R.drawable.ic_transportation)
                ExpenseCategory.FOOD -> setImageResource(R.drawable.ic_food)
                ExpenseCategory.ENTERTAINMENT -> setImageResource(R.drawable.ic_entertainment)
                ExpenseCategory.BILLS -> setImageResource(R.drawable.ic_fees)
                ExpenseCategory.EDUCATION -> setImageResource(R.drawable.ic_education)
                ExpenseCategory.HEALTH -> setImageResource(R.drawable.ic_health)
                else -> setImageResource(R.drawable.ic_other)
            }
        }
    }
}

class ExpenseDiffUtils : DiffUtil.ItemCallback<Expense>() {
    override fun areItemsTheSame(oldItem: Expense, newItem: Expense): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Expense, newItem: Expense): Boolean {
        return oldItem == newItem
    }

}