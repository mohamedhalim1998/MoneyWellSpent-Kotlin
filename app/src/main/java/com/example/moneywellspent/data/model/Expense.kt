package com.example.moneywellspent.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val amount: Double?,
    val category: ExpenseCategory?,
    val date: Date?,
    val note: String?,
    val walletId: Long?,
)
