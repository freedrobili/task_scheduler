package com.pattern.task_scheduler.controller

import com.pattern.task_scheduler.model.Task
import com.pattern.task_scheduler.service.TaskService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
@RequestMapping("/tasks")
class TaskController(private val taskService: TaskService) {

    @GetMapping("/createdByMe")
    fun tasksCreatedByMe(model: Model): String {
        val username = "currentLoggedInUser" // Замените на актуальное имя пользователя
        val tasks = taskService.getTasksCreatedBy(username)
        model.addAttribute("tasks", tasks)
        return "tasks/createdByMe"
    }

    @GetMapping("/assignedToMe")
    fun tasksAssignedToMe(model: Model): String {
        val username = "currentLoggedInUser" // Замените на актуальное имя пользователя
        val tasks = taskService.getTasksAssignedTo(username)
        model.addAttribute("tasks", tasks)
        return "tasks/assignedToMe"
    }

    @GetMapping("/favorites")
    fun favoriteTasks(model: Model): String {
        val username = "currentLoggedInUser" // Замените на актуальное имя пользователя
        val tasks = taskService.getFavoriteTasks(username)
        model.addAttribute("tasks", tasks)
        return "tasks/favorites"
    }

    @GetMapping("/add")
    fun showAddTaskForm(model: Model): String {
        model.addAttribute("task", Task())
        return "tasks/add"
    }

    @PostMapping("/add")
    fun addTask(task: Task): String {
        val username = "currentLoggedInUser" // Замените на актуальное имя пользователя
        task.createdBy = username
        taskService.addTask(task)
        return "redirect:/tasks/createdByMe"
    }

    @PostMapping("/{taskId}/start")
    fun startTask(@PathVariable taskId: Long): String {
        val task = taskService.getTaskById(taskId)
        taskService.startTask(task)
        return "redirect:/tasks/createdByMe"
    }

    @PostMapping("/{taskId}/complete")
    fun completeTask(@PathVariable taskId: Long): String {
        val task = taskService.getTaskById(taskId)
        taskService.completeTask(task)
        return "redirect:/tasks/createdByMe"
    }

    @PostMapping("/{taskId}/cancel")
    fun cancelTask(@PathVariable taskId: Long): String {
        val task = taskService.getTaskById(taskId)
        taskService.cancelTask(task)
        return "redirect:/tasks/createdByMe"
    }

}