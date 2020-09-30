package com.vk59.tasklist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.vk59.tasklist.db.Task
import com.vk59.tasklist.db.TaskDB
import com.vk59.tasklist.db.TaskDao

class TasksViewModel(application: Application) : AndroidViewModel(application) {
    private var db: TaskDB = TaskDB.getDatabase(application)!!
    private var dao: TaskDao = db.taskDao()!!

    var tasksList: LiveData<List<Task>> = dao.getAllTasks()

    fun insertTask(task: Task) {
        TaskDB.databaseWriteExecutor.execute {
            dao.insert(task)
        }
    }

    fun deleteTask(task: Task) {
        TaskDB.databaseWriteExecutor.execute {
            dao.delete(task)
        }
    }

    fun deleteAllTasks() {
        TaskDB.databaseWriteExecutor.execute {
            dao.deleteAll()
        }
    }


}