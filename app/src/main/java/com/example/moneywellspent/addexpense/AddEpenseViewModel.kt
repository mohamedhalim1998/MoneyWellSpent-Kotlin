package com.example.moneywellspent.addexpense

import androidx.lifecycle.*
import com.example.moneywellspent.data.database.ExpenseDAO
import com.example.moneywellspent.data.model.CategoryData
import com.example.moneywellspent.data.model.Expense
import com.example.moneywellspent.data.model.ExpenseCategory
import com.example.moneywellspent.data.model.categories
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*

class AddExpenseViewModel(private val database: ExpenseDAO) : ViewModel() {
    private val _date: MutableLiveData<Long> = MutableLiveData(System.currentTimeMillis())
    val data: LiveData<Long>
        get() = _date
    private val _time: MutableLiveData<Long> = MutableLiveData(System.currentTimeMillis())
    val time: LiveData<Long>
        get() = _time
    private val _category: MutableLiveData<CategoryData> =
        MutableLiveData(categories[ExpenseCategory.OTHER])
    val category: LiveData<CategoryData>
        get() = _category

    fun changeDate(mills: Long) {
        _date.value = mills
    }


    fun changeTime(mills: Long) {
        Timber.d("$mills")
        _time.value = mills
    }

    fun changeCategory(category: ExpenseCategory) {
        _category.value = categories[category]
    }

    fun addExpense(expense: Expense) {
        viewModelScope.launch { database.addExpense(expense) }
    }

}

class AddExpenseViewModelFactory(private val database: ExpenseDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddExpenseViewModel::class.java)) {
            return AddExpenseViewModel(database) as T
        }
        throw IllegalArgumentException()
    }

}