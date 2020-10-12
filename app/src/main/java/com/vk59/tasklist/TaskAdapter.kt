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

            when(task.taskImportance) {
                Task.TASK_IMPORTANCE_LOW -> holder.imageImportance.setImageResource(R.drawable.ic_three)
                Task.TASK_IMPORTANCE_NORMAL -> holder.imageImportance.setImageResource(R.drawable.ic_two)
                Task.TASK_IMPORTANCE_HIGH -> holder.imageImportance.setImageResource(R.drawable.ic_one)
            }

            when(task.taskStatus) {
                Task.TASK_STATUS_FINISHED -> holder.imageTaskStatus.setImageResource(R.drawable.ic_done)
                Task.TASK_STATUS_NOT_FINISHED -> holder.imageTaskStatus.setImageResource(R.drawable.ic_not_done)
            }

            holder.textTaskDescription.text = task.taskDescription
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