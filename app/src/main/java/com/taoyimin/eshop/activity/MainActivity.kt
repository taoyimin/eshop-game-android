package com.taoyimin.eshop.activity

import android.support.v4.app.Fragment
import com.taoyimin.eshop.R
import com.taoyimin.eshop.adapter.MainViewPagerAdapter
import com.taoyimin.eshop.fragment.GameListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private var fragmentList = ArrayList<Fragment>()
    private val titleArray by lazy { this.resources.getStringArray(R.array.view_pager_tab) }

    override fun setContentViewId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        for (title in titleArray){
            fragmentList.add(GameListFragment.getInstance(title))
        }
        view_pager.adapter = MainViewPagerAdapter(supportFragmentManager, fragmentList, titleArray)
        tab_layout.setupWithViewPager(view_pager)
    }

    override fun loadData() {

    }
}
