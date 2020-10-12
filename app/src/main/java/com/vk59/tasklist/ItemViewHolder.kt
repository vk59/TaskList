package com.vk59.tasklist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var taskNameText: TextView = itemView.findViewById(R.id.taskNameText)
    var textTaskDescription: TextView = itemView.findViewById(R.id.textTaskDescription)
    var imageTaskStatus: ImageView = itemView.findViewById(R.id.imageTaskStatus)
    var imageImportance: ImageView = itemView.findViewById(R.id.imageImportance)
}