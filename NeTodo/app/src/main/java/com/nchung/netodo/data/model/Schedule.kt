package com.nchung.netodo.data.model

data class Schedule(var id: Int, var title: String, val tasks: List<Task>) {
    fun itemInProgress() = tasks.filter { it.state == TaskState.IN_PROGRESS }
    fun itemDone() = tasks.filter { it.state == TaskState.DONE }
    fun itemOverdue() = tasks.filter { it.state == TaskState.OVERDUE }
}
