package com.vk59.tasklist.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(task: Task?)

    @Delete
    fun delete(task: Task?)

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): LiveData<List<Task>>

    @Update
    fun updateTask(task: Task?)

    @Query("DELETE FROM tasks")
    fun deleteAll()

    @Query("SELECT * FROM tasks WHERE id = :id")
    fun getTask(id: Long): LiveData<Task?>?
}