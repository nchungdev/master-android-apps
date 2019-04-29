package com.nchung.netodo.data.model

data class Task(
        var id: Int,
        var name: String,
        var note: String,
        var remindTime: Long,
        var repeatMode: RepeatMode,
        var priority: Priority,
        var location: Location,
        var peoples: List<People>,
        @TaskState var state: Int
)
