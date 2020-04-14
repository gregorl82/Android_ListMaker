package com.example.android.listmaker.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.listmaker.views.ListItemViewHolder
import com.example.android.listmaker.R
import com.example.android.listmaker.models.TaskList

class ListItemsRecyclerViewAdapter(var list: TaskList) : RecyclerView.Adapter<ListItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_view_holder, parent, false)

        return ListItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.tasks.size
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.taskTextView.text = list.tasks[position]
    }
}