package com.example.musicsearchapp.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.musicsearchapp.R
import com.example.musicsearchapp.fragments.TracksFragment
import com.example.musicsearchapp.viewModel.TracksViewModel

class MainActivity : BaseActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(TracksViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        this.parentView = View.inflate(this, R.layout.activity_main, null)
        setContentView(parentView)

        val fragment = TracksFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}