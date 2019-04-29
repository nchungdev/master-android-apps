package com.nchung.netodo.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

enum class CalendarType(@StringRes val typeName: Int, @DrawableRes val bitmapDrawable: Int) {
    FAMILY(-1, -1),
    PERSONAL(-1, -1),
    WORK(-1, -1),
    RELATIONSHIP(-1, -1),
    FRIENDS(-1, -1),
    OTHER(-1, -1),
}
