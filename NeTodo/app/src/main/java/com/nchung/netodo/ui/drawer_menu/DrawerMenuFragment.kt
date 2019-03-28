package com.nchung.netodo.ui.drawer_menu

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nchung.netodo.R
import com.nchung.netodo.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_drawer_menu.*

class DrawerMenuFragment : BaseFragment<DrawerMenuViewModel>() {
    override fun getViewModel(): DrawerMenuViewModel = drawerMenuViewModel

    private val drawerMenuViewModel by lazy(mode = LazyThreadSafetyMode.NONE) {
        getViewModel(this, DrawerMenuViewModel::class.java)
    }

    override fun getLayoutId() = R.layout.fragment_drawer_menu

    override fun bindViews(view: View?) {
        val drawerMenuAdapter = DrawerMenuAdapter()
        rv_static_menu.adapter = drawerMenuAdapter
        rv_static_menu.layoutManager = LinearLayoutManager(context)
        getViewModel().getDrawerMenuItems().observe(this, Observer {
            drawerMenuAdapter.setItems(it)
        })
    }

    companion object {
        val TAG = this::class.java.name

        fun newInstance() = DrawerMenuFragment()
    }
}
