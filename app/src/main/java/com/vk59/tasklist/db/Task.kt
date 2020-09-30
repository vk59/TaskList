package com.vk59.tasklist.db

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task (
    @NonNull
    var taskName: String,

    var taskDescription: String = " ",

    var taskStatus: Int = TASK_STATUS_NOT_FINISHED,

    var taskImportance: Int = TASK_IMPORTANCE_NORMAL
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    companion object {
        const val TASK_STATUS_NOT_FINISHED = 0
        const val TASK_STATUS_FINISHED = 1
        const val TASK_IMPORTANCE_LOW = 0
        const val TASK_IMPORTANCE_NORMAL = 1
        const val TASK_IMPORTANCE_HIGH = 2
    }
}