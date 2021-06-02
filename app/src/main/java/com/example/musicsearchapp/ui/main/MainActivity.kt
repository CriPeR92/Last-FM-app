package com.example.musicsearchapp.ui.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.musicsearchapp.R
import com.example.musicsearchapp.base.BaseActivity
import com.example.musicsearchapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        binding.apply {
            lifecycleOwner = this@MainActivity
        }

        val fragment = MainFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}