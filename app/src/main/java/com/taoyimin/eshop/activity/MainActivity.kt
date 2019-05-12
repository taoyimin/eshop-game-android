package com.taoyimin.eshop.activity

import android.support.design.widget.AppBarLayout
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import com.taoyimin.eshop.R
import com.taoyimin.eshop.adapter.MainViewPagerAdapter
import com.taoyimin.eshop.fragment.GameListFragment

class MainActivity : BaseActivity() {
    private var appbarLayout: AppBarLayout? = null
    private var toolBar: Toolbar? = null
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null
    private var fragmentList = ArrayList<Fragment>()
    private var titleArray = arrayOf("标题1","标题2","标题3","标题4")

    override fun setContentViewId(): Int {
        return R.layout.activity_main
    }

    override fun findViewsById() {
        appbarLayout = findViewById(R.id.appbar_layout)
        toolBar = findViewById(R.id.toolbar)
        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)
    }

    override fun initEvent() {
        for (title in titleArray){
            fragmentList.add(GameListFragment.getInstance(title))
        }
        viewPager!!.adapter = MainViewPagerAdapter(supportFragmentManager, fragmentList, titleArray)
        tabLayout!!.setupWithViewPager(viewPager)
    }

    override fun initInterface() {

    }

    override fun loadData() {

    }
}
