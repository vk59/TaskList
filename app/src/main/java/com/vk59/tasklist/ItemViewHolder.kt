package com.vk59.tasklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vk59.tasklist.db.Task

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var taskNameText: TextView = itemView.findViewById(R.id.taskNameText)
    var textTaskDescription: TextView = itemView.findViewById(R.id.textTaskDescription)
    var imageTaskStatus: ImageView = itemView.findViewById(R.id.imageTaskStatus)
    var imageImportance: ImageView = itemView.findViewById(R.id.imageImportance)


    fun bind(task: Task) {
        taskNameText.text = task.taskName

        when (task.taskImportance) {
            Task.TASK_IMPORTANCE_LOW -> imageImportance.setImageResource(R.drawable.ic_three)
            Task.TASK_IMPORTANCE_NORMAL -> imageImportance.setImageResource(R.drawable.ic_two)
            Task.TASK_IMPORTANCE_HIGH -> imageImportance.setImageResource(R.drawable.ic_one)
        }

        when (task.taskStatus) {
            Task.TASK_STATUS_FINISHED -> imageTaskStatus.setImageResource(R.drawable.ic_done)
            Task.TASK_STATUS_NOT_FINISHED -> imageTaskStatus.setImageResource(R.drawable.ic_not_done)
        }

        textTaskDescription.text = task.taskDescription
    }

    companion object {
        fun from(parent: ViewGroup): ItemViewHolder {
            val inflater: LayoutInflater = LayoutInflater.from(parent.context)
            val view: View = inflater.inflate(R.layout.item_list, parent, false)
            return ItemViewHolder(view)
        }
    }
}