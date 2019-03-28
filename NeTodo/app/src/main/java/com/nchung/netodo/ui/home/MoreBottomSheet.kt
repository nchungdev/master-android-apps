package com.nchung.netodo.ui.home

import com.nchung.netodo.R
import com.nchung.netodo.ui.base.BaseBottomSheet

class MoreBottomSheet : BaseBottomSheet() {
    override fun getLayoutId() = R.layout.layout_more_bottom_sheet

    companion object {
        val instance: MoreBottomSheet by lazy { MoreBottomSheet() }
    }
}
