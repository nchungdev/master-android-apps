package com.nchung.netodo.data.model

data class Task(
    var id: Int,
    var name: String,
    var remindTime: Long,
    var deadline: Long,
    var repeatMode: RepeatMode,
    var taskType: TaskType,
    var note: String
)
