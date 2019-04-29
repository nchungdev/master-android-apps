package com.nchung.netodo.data.model

annotation class TaskState {
    companion object {
        const val IN_PROGRESS = 1
        const val DONE = 0
        const val OVERDUE = -1
    }
}
