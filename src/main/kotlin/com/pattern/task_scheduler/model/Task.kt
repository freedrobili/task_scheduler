package com.pattern.task_scheduler.model

import com.pattern.task_scheduler.TaskState
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
data class Task(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var title: String = "",
    var description: String? = null,
    var assignedTo: String? = null,
    var createdBy: String = "",
    var isFavorite: Boolean = false,
) {
    // Инициализация начального состояния
    var state: TaskState = PlannedState()

    // Методы делегируются текущему состоянию
    fun start() {
        state.start(this)
    }

    fun complete() {
        state.complete(this)
    }

    fun cancel() {
        state.cancel(this)
    }
}
