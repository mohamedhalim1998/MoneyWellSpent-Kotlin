package com.example.moneywellspent.data.model

data class Expense(
    val id: Long,
    val amount: Double,
    val category: ExpenseCategory,
    val date: Long,
    val note: String,
    val wallet: Wallet,
)
