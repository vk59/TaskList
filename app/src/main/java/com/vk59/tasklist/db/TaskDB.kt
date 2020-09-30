package com.vk59.tasklist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.*
import java.util.concurrent.Executors

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDB : RoomDatabase(){
    abstract fun taskDao(): TaskDao?

    companion object {
        @Volatile
        private var INSTANCE: TaskDB? = null
        private val NUMBER_OF_THREADS = 4
        val databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS)
        fun getDatabase(context: Context): TaskDB? {
            if (INSTANCE == null) {
                synchronized(TaskDB::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDB::class.java,
                        "tasks.db"
                    )
                        .addCallback(sRoomDatabaseCallback)
                        .build()
                }
            }
            return INSTANCE
        }

        // inflating in the first app's loading
        private val sRoomDatabaseCallback: Callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                databaseWriteExecutor.execute {
                    val dao: TaskDao = INSTANCE!!.taskDao()!!
                    dao.deleteAll()
                    var task: Task
                    for (i in 0..29) {
                        task = Task(
                            "Task $i",
                            "Task description $i",
                            Task.TASK_STATUS_NOT_FINISHED,
                            Random().nextInt(3)
                        )
                        dao.insert(task)
                    }
                }
            }
        }
    }
}