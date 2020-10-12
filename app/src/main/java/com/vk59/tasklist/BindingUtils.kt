package com.vk59.tasklist

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.vk59.tasklist.db.Task

class BindingUtils {
    companion object {
        @JvmStatic
        @BindingAdapter("taskImportanceImage")
        fun setImportanceImage(image: ImageView, task: Task) {
            var resImp: Int? = null
            when (task.taskImportance) {
                Task.TASK_IMPORTANCE_LOW -> resImp = R.drawable.ic_three
                Task.TASK_IMPORTANCE_NORMAL -> resImp = R.drawable.ic_two
                Task.TASK_IMPORTANCE_HIGH -> resImp = R.drawable.ic_one
            }
            image.setImageResource(resImp!!)
        }

        @JvmStatic
        @BindingAdapter("taskStatusImage")
        fun setStatusImage(image: ImageView, task: Task) {
            var resStatus: Int? = null
            when (task.taskStatus) {
                Task.TASK_STATUS_FINISHED -> resStatus = R.drawable.ic_done
                Task.TASK_STATUS_NOT_FINISHED -> resStatus = R.drawable.ic_not_done
            }
            image.setImageResource(resStatus!!)
        }
    }
}