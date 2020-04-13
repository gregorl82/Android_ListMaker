package com.example.android.listmaker

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val taskTextView = itemView.findViewById(R.id.textViewTask) as TextView
}