package com.taoyimin.eshop.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.taoyimin.eshop.MyApplication


/**
 * Created by Tao Yimin on 2016/9/12.
 * 所有Activity的基类
 */
abstract class BaseActivity : AppCompatActivity() {
    private var application: MyApplication? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (application == null) {
            // 得到Application对象
            application = getApplication() as MyApplication
        }
        //设置应用为竖屏显示，不跟随系统旋转
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        application!!.addActivity(this)
        setContentView(setContentViewId())
        //初始化控件
        findViewsById()
        //初始化事件
        initEvent()
        //初始化界面
        initInterface()
        //加载数据
        loadData()
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
    protected abstract fun findViewsById()

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

    override fun onDestroy() {
        super.onDestroy()
        application!!.removeActivity(this)
    }
}
