package com.example.moneywellspent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomappbar.BottomAppBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val bottomBar = findViewById<BottomAppBar>(R.id.bottom_app_bar)
        NavigationUI.setupWithNavController(bottomBar, navController)
    }
}