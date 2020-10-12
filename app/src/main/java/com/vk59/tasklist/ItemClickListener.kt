package com.vk59.tasklist

import com.vk59.tasklist.db.Task

interface ItemClickListener {
    fun onClick(task: Task)
}