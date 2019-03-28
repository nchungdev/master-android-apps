package com.nchung.netodo.ui.drawer_menu

import androidx.lifecycle.MutableLiveData
import com.nchung.netodo.R
import com.nchung.netodo.ui.base.BaseViewModel
import javax.inject.Inject

class DrawerMenuViewModel @Inject constructor() : BaseViewModel() {
    private val drawerMenuItems: MutableLiveData<List<DrawerMenuItem>> = MutableLiveData()

    fun getDrawerMenuItems() = drawerMenuItems

    init {
        val drawerMenuItem = DrawerMenuItem(R.drawable.ic_add_24dp, R.string.app_name, 1)
        val list = mutableListOf(drawerMenuItem)
        drawerMenuItems.postValue(list)
    }
}
