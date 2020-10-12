package com.vk59.tasklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vk59.tasklist.db.Task

class TaskAdapter : RecyclerView.Adapter<ItemViewHolder>() {
    private var data: List<Task>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        if (data != null) {
            val task: Task = data!![position]
            holder.bind(task)
        } else
        {
            holder.taskNameText.text = ("No tasks")
        }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    fun setData(data: List<Task>?) {
        this.data = data
        notifyDataSetChanged()
    }

}