package com.nchung.netodo.ui.add_todo

import com.nchung.netodo.R
import com.nchung.netodo.ui.base.BaseBottomSheet

class AddToDoBottomSheet : BaseBottomSheet() {
    override fun getLayoutId() = R.layout.layout_add_todo_bottom_sheet

    companion object {
        val instance: AddToDoBottomSheet by lazy { AddToDoBottomSheet() }
    }
}
