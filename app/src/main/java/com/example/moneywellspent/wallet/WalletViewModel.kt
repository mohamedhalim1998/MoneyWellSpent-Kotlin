package com.example.moneywellspent.wallet

import androidx.lifecycle.*
import com.example.moneywellspent.data.database.ExpenseDAO
import com.example.moneywellspent.data.model.Wallet
import kotlinx.coroutines.Dispatchers

class WalletViewModel(private val database: ExpenseDAO) : ViewModel() {

    val wallets: LiveData<List<Wallet>> = database.getWallets().asLiveData(Dispatchers.IO);
}

class WalletViewModelFactory(private val database: ExpenseDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WalletViewModel::class.java)) {
            return WalletViewModel(database) as T
        }
        throw IllegalArgumentException()
    }

}