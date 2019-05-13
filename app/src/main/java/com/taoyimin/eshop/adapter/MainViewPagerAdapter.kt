package com.taoyimin.eshop.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter



/**
 * Created by Tao Yimin on 2019/5/9.
 */
class MainViewPagerAdapter(
        fm: FragmentManager,
        private var fragmentList: List<Fragment>,
        private var titleArray: Array<String>)
    : FragmentPagerAdapter(fm) {

    /*init {
        setFragments(fm, fragmentList, titleArray)
    }

    private fun setFragments(fm: FragmentManager, fragmentList: List<Fragment>, titleArray: Array<String>) {
        this.titleArray = titleArray
        val ft = fm.beginTransaction()
        this.fragmentList.forEach { ft.remove(it) }
        ft.commitAllowingStateLoss()
        fm.executePendingTransactions()
        this.fragmentList = fragmentList
        notifyDataSetChanged()
    }*/

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