package com.vk59.tasklist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vk59.tasklist.db.Task
import com.vk59.tasklist.db.TaskDB
import com.vk59.tasklist.db.TaskDao

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private var db: TaskDB = TaskDB.getDatabase(application)!!
    private var dao: TaskDao = db.taskDao()!!

    var task: LiveData<Task?>? = null

    var _eventTaskAdd = MutableLiveData<Boolean>()

    var _eventTaskUpdate = MutableLiveData<Boolean>()

    fun eventTaskAddFinished() {
        _eventTaskAdd.value = false
    }

    fun eventTaskUpdateFinished() {
        _eventTaskUpdate.value = false
    }

    init {
        _eventTaskAdd.value = false
    }

    fun insertTask(task: Task?) {
        TaskDB.databaseWriteExecutor.execute { dao.insert(task) }
        _eventTaskAdd.setValue(true)
    }

    fun getTask(id: Long) {
        task = dao.getTask(id)
    }

    fun updateTask() {
        TaskDB.databaseWriteExecutor.execute { dao.updateTask(task?.value) }
        _eventTaskUpdate.value = true
    }

}