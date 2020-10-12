package com.vk59.tasklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vk59.tasklist.db.Task

class TaskAdapter : RecyclerView.Adapter<ItemViewHolder>() {
    private var data: List<Task>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_list, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        if (data != null) {
            val task: Task = data!![position]
            holder.taskNameText.text = task.taskName
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