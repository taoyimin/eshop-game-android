package com.taoyimin.eshop.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.taoyimin.eshop.MyApplication


/**
 * Created by Tao Yimin on 2016/9/12.
 * 所有Activity的基类
 */
abstract class BaseActivity : AppCompatActivity() {
    private var application = MyApplication.context as MyApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置应用为竖屏显示，不跟随系统旋转
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        application.addActivity(this)
        setContentView(setContentViewId())
        //初始化控件
        initView()
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
    protected abstract fun initView()

    /**
     * 加载数据
     */
    protected abstract fun loadData()

    override fun onDestroy() {
        super.onDestroy()
        application.removeActivity(this)
    }
}
