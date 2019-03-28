package com.nchung.netodo.ui.home

import android.content.Context
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.nchung.netodo.R
import com.nchung.netodo.ui.add_todo.AddToDoBottomSheet
import com.nchung.netodo.ui.base.BaseActivity
import com.nchung.netodo.ui.drawer_menu.DrawerMenuFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_home.*


class HomeActivity : BaseActivity<HomeViewModel>() {

    private val homeViewModel: HomeViewModel by lazy(mode = LazyThreadSafetyMode.NONE) {
        getViewModel(this, HomeViewModel::class.java)
    }

    override fun getLayoutId() = R.layout.activity_main

    override fun getViewModel() = homeViewModel

    override fun bindViews() {
        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.setHomeAsUpIndicator(R.drawable.ic_menu_24px)
        fab.setOnClickListener { AddToDoBottomSheet.instance.show(supportFragmentManager) }

        supportFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, DrawerMenuFragment.newInstance())
                .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> drawer_layout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        @JvmStatic
        fun makeIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }
}
