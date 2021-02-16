package com.example.moneywellspent.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Wallet(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val balance: Double?,
    val name: String?,
)