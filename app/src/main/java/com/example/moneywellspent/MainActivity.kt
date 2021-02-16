package com.example.moneywellspent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.room.Database
import com.example.moneywellspent.data.database.ExpenseDatabase
import com.example.moneywellspent.data.model.Expense
import com.example.moneywellspent.data.model.ExpenseCategory
import com.example.moneywellspent.data.model.Wallet
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val scope = CoroutineScope(Dispatchers.IO);
        NavigationUI.setupWithNavController(bottomBar, navController)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        val db = ExpenseDatabase.getInstance(this)
        fab.setOnClickListener {
            scope.launch {
                db.dao.addWallet(
                    Wallet(id = null, balance = 500.0, name = "WALLET")
                )
                Timber.d("ADD WALLET")
                db.dao.addExpense(
                    Expense(
                        null,
                        50.0,
                        ExpenseCategory.OTHER,
                        Date(),
                        "this a note",
                        0
                    )
                )
                Timber.d("ADD EXPENSE")
            }
        }
    }
}