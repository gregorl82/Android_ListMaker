package com.example.android.listmaker.views

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.listmaker.R

class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val taskTextView = itemView.findViewById(R.id.textViewTask) as TextView
}
