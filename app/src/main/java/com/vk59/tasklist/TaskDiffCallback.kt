package com.vk59.tasklist

import androidx.recyclerview.widget.DiffUtil
import com.vk59.tasklist.db.Task

class TaskDiffCallback : DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        if (oldItem.id == newItem.id) {
            return true
        }
        return false
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }
}