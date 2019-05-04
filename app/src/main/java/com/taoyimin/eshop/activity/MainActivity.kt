package com.taoyimin.eshop.activity

import com.taoyimin.eshop.R
import com.taoyimin.eshop.adapter.GameAdapter
import com.taoyimin.eshop.bean.Game

class MainActivity : BaseActivity() {
    val adapter:GameAdapter?=null
    val games:MutableList<Game> = ArrayList()

    override fun setContentViewId(): Int {
        return R.layout.activity_main
    }

    override fun findViewsById() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initEvent() {
    }

    override fun initInterface() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
