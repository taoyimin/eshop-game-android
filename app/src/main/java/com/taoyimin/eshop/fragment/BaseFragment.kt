package com.taoyimin.eshop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Tao Yimin on 2019/5/10.
 * 所有Fragment的基类，通过懒加载实现数据的加载
 */
abstract class BaseFragment : androidx.fragment.app.Fragment() {
    //视图是否加载完毕
    private var isViewPrepare = false
    //是否加载过数据
    private var hasLoadData = false

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        lazyLoadData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(setContentViewId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewPrepare = true
        initView()
        lazyLoadData()
    }

    private fun lazyLoadData(){
        if (userVisibleHint && isViewPrepare && !hasLoadData) {
            loadData()
            hasLoadData = true
        }
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
    protected abstract fun initView()


    /**
     * 加载数据
     */
    protected abstract fun loadData()

}
