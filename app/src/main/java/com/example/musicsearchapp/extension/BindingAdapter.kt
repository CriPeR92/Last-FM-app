package com.example.musicsearchapp.extension

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * binder for the recyclerView
 */
@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}

/**
 * bind to know when to hide or show a view
 */
@BindingAdapter("app:hideIfSaved")
fun hideIfSaved(view: View, number: Int) {
    view.visibility = if (number == 0) View.GONE else View.VISIBLE
}