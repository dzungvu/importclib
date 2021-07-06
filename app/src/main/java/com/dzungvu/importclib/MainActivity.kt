package com.dzungvu.importclib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    private val viewModel = MainActivityViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val returnData = viewModel.getStringFromJNI("DzungVu")
        Log.d("MainActivity", returnData)
    }
}