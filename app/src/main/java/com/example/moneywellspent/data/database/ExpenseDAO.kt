package com.example.moneywellspent.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.moneywellspent.data.model.Expense
import com.example.moneywellspent.data.model.Wallet
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface ExpenseDAO {
    @Insert
    suspend fun addWallet(wallet: Wallet)

    @Insert
    suspend fun addExpense(expense: Expense)

    @Query("SELECT * FROM expenses")
    fun getAllExpense(): Flow<List<Expense>>

    @Query("SELECT SUM(amount) as total FROM expenses WHERE date BETWEEN :from AND :to")
    fun getPaymentBetween(from: Date, to: Date): Flow<Double>
}