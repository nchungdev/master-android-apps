package com.nchung.netodo.ui.home

import com.nchung.netodo.R
import com.nchung.netodo.ui.base.BaseBottomSheet

class MainBottomSheet : BaseBottomSheet() {
    override fun getLayoutId() = R.layout.layout_main_bottom_sheet

    companion object {
        val instance: MainBottomSheet by lazy { MainBottomSheet() }
    }
}
