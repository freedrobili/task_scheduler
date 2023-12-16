package com.pattern.task_scheduler

import com.pattern.task_scheduler.model.Task

interface TaskState {
    fun start(task: Task)
    fun complete(task: Task)
    fun cancel(task: Task)
}
