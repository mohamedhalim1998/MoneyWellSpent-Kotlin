package com.example.moneywellspent.expenses

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.moneywellspent.data.database.ExpenseDAO
import com.example.moneywellspent.data.model.Expense
import kotlinx.coroutines.Dispatchers

class ExpensesViewModel(private val database: ExpenseDAO) : ViewModel() {
    val expenses: LiveData<List<Expense>> = database.getAllExpense().asLiveData(Dispatchers.IO)
}

class ExpensesViewModelFactory(private val database: ExpenseDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExpensesViewModel::class.java)) {
            return ExpensesViewModel(database) as T
        }
        throw IllegalArgumentException()
    }

}