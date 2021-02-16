package com.example.moneywellspent.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moneywellspent.data.model.Expense
import com.example.moneywellspent.data.model.Wallet
import com.example.moneywellspent.util.RoomConverters

@Database(entities = [Expense::class, Wallet::class], version = 1, exportSchema = false)
@TypeConverters(RoomConverters::class)
abstract class ExpenseDatabase : RoomDatabase() {
    abstract val dao: ExpenseDAO

    companion object {
        @Volatile
        private var sInstance: ExpenseDatabase? = null

        fun getInstance(context: Context): ExpenseDatabase {
            var instance = sInstance
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExpenseDatabase::class.java,
                    "expenses.db"
                ).fallbackToDestructiveMigration().build()
            }
            sInstance = instance
            return instance;
        }
    }

}