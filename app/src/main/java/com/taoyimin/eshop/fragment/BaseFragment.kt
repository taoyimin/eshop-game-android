package com.taoyimin.eshop.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Tao Yimin on 2016/9/12.
 * 所有Fragment的基类
 */
abstract class BaseFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(setContentViewId(), container, false)
        //初始化控件
        findViewsById(view)
        //初始化事件
        initEvent()
        //初始化界面
        initInterface()
        //加载数据
        loadData()
        return view
    }

    /**
     * 设置布局
     *
     * @return
     */
    protected abstract fun setContentViewId(): Int

    /**
     * 初始化控件
     */
    protected abstract fun findViewsById(view: View)

    /**
     * 初始化事件
     */
    protected abstract fun initEvent()

    /**
     * 初始化界面
     */
    protected abstract fun initInterface()

    /**
     * 加载数据
     */
    protected abstract fun loadData()
}
