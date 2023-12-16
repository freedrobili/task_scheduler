package com.pattern.task_scheduler.model

import com.pattern.task_scheduler.TaskState
import com.pattern.task_scheduler.model.Task

class PlannedState : TaskState {
    override fun start(task: Task) {
        task.state = InProgressState()
        // Дополнительные действия при начале выполнения задачи
    }

    override fun complete(task: Task) {
        // Задача еще не в процессе выполнения
        throw IllegalStateException("Cannot complete a task that is not in progress.")
    }

    override fun cancel(task: Task) {
        task.state = CompletedState()
        // Дополнительные действия при отмене задачи
    }
}

class InProgressState : TaskState {
    override fun start(task: Task) {
        // Задача уже в процессе выполнения
        throw IllegalStateException("Task is already in progress.")
    }

    override fun complete(task: Task) {
        task.state = CompletedState()
        // Дополнительные действия при завершении задачи
    }

    override fun cancel(task: Task) {
        task.state = PlannedState()
        // Дополнительные действия при отмене задачи
    }
}

class CompletedState : TaskState {
    override fun start(task: Task) {
        // Завершенную задачу нельзя начать
        throw IllegalStateException("Cannot start a completed task.")
    }

    override fun complete(task: Task) {
        // Завершенную задачу нельзя завершить еще раз
        throw IllegalStateException("Task is already completed.")
    }

    override fun cancel(task: Task) {
        // Завершенную задачу нельзя отменить
        throw IllegalStateException("Cannot cancel a completed task.")
    }
}
