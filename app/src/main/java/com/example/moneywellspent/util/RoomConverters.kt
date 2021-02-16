package com.example.moneywellspent.util

import androidx.room.TypeConverter
import com.example.moneywellspent.data.model.ExpenseCategory
import java.util.*

class RoomConverters {
    @TypeConverter
    fun fromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun toDate(value: Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun fromExpenseCategory(expenseCategory: ExpenseCategory): String {
        return expenseCategory.name;
    }

    @TypeConverter
    fun fromExpenseCategory(name: String): ExpenseCategory {
        return ExpenseCategory.valueOf(name)
    }
}