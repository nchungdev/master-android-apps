package com.nchung.netodo.data.model

import android.graphics.Bitmap
import androidx.annotation.ColorInt

class CalendarItem(
        var id: Int,
        var name: String,
        var description: String,
        var owner: User,
        var sharedUsers: List<User>,
        var calendarType: CalendarType,
        var coverImage: Bitmap? = null,
        @ColorInt var color: Int
)