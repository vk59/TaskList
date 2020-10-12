package com.vk59.tasklist

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.vk59.tasklist.db.Task

class TaskAdapter(
    diffCallback: TaskDiffCallback,
    private val itemClickListener: ItemClickListener
)
        : ListAdapter<Task, ItemViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        if (currentList != null) {
            val task: Task = getItem(position)
            holder.bind(task, itemClickListener)
        } else
        {
            holder.binding.taskNameText.text = ("No tasks")
        }
    }
}