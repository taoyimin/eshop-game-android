package com.taoyimin.eshop.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by Tao Yimin on 2019/5/9.
 */
class MainViewPagerAdapter(
        fm: FragmentManager,
        private var fragmentList: List<Fragment>,
        private var titleArray: Array<String>)
    : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleArray[position]
    }
}