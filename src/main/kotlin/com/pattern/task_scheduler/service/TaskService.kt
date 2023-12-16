package com.pattern.task_scheduler.service

import com.pattern.task_scheduler.model.Task
import com.pattern.task_scheduler.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(private val taskRepository: TaskRepository) {
    fun getTasksCreatedBy(username: String): List<Task> {
        return taskRepository.findByCreatedBy(username)
    }

    fun getTasksAssignedTo(username: String): List<Task> {
        return taskRepository.findByAssignedTo(username)
    }

    fun getFavoriteTasks(username: String): List<Task> {
        return taskRepository.findByCreatedByAndIsFavorite(username, true)
    }

    fun addTask(task: Task): Task {
        return taskRepository.save(task)
    }

    fun startTask(task: Task) {
        // Передать управление состоянием задачи
        task.state.start(task)
        taskRepository.save(task)
    }

    fun completeTask(task: Task) {
        task.state.complete(task)
        taskRepository.save(task)
    }

    fun cancelTask(task: Task) {
        task.state.cancel(task)
        taskRepository.save(task)
    }


    fun getTaskById(taskId: Long): Task {
        return taskRepository.findById(taskId)
            .orElseThrow { NoSuchElementException("Task not found with ID: $taskId") }
    }
}