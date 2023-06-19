package com.aplus.news.extension

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.setLinearAdapter(value: RecyclerView.Adapter<*>) {
    adapter = value
    layoutManager = LinearLayoutManager(context)
}

fun RecyclerView.setLinearAdapter(value: RecyclerView.Adapter<*>, orientation: Int) {
    adapter = value
    layoutManager = LinearLayoutManager(context, orientation, false)
}

fun RecyclerView.setGridAdapter(value: RecyclerView.Adapter<*>, grid: Int) {
    adapter = value
    layoutManager = GridLayoutManager(context, grid)
}