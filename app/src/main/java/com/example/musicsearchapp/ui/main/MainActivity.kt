package com.example.musicsearchapp.ui.main

import android.os.Bundle
import com.example.musicsearchapp.R
import com.example.musicsearchapp.base.BaseActivity
import com.example.musicsearchapp.databinding.ActivityMainBinding

/**
 * MainActivity: only contains the fragment
 */

class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        binding.apply {
            lifecycleOwner = this@MainActivity
        }

        val fragment = TracksFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}