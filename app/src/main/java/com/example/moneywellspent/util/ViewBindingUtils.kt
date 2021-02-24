package com.example.moneywellspent.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("android:formatDate")
fun TextView.formatDate(date: Long) {
    Timber.d("date: $date")
    val d = Date(date)
    val formatter = SimpleDateFormat("dd/MM/YYYY")
    text = formatter.format(d)
}

@BindingAdapter("android:formatTime")
fun TextView.formatTime(time: Long) {
    Timber.d("time: $time")
    val d = Date(time)
    val formatter = SimpleDateFormat("hh:mm a")
    text = formatter.format(d)
}

@BindingAdapter("android:icon")
fun ImageView.icon(res: Int) {
    setImageResource(res)
}

@BindingAdapter("android:textNum")
fun TextView.textNum(i: Double) {
    text = String.format("%.2f", i)
}