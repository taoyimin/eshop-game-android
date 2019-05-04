package com.taoyimin.eshop

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import java.util.*

/**
 * Created by Tao Yimin on 2018/1/19.
 */

class MyApplication : Application() {
    //用于存放所有启动的Activity的集合
    private var activities: MutableList<Activity>? = null

    //获取SharedPreferences
    val appPreferences: SharedPreferences
        get() = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    override fun onCreate() {
        super.onCreate()
        //初始化xutil
        //x.Ext.init(this);
        //x.Ext.setDebug(BuildConfig.DEBUG);
        //初始化上下文对象
        context = applicationContext as MyApplication
        activities = ArrayList()
    }

    //SharedPreferences存储String类型
    fun saveAppPreference(name: String, `val`: String) {
        val editor = appPreferences.edit()
        editor.putString(name, `val`)
        editor.commit()
    }

    //SharedPreferences存储boolean类型
    fun saveAppPreference(name: String, `val`: Boolean) {
        val editor = appPreferences.edit()
        editor.putBoolean(name, `val`)
        editor.commit()
    }

    //SharedPreferences存储int类型
    fun saveAppPreference(name: String, `val`: Int) {
        val editor = appPreferences.edit()
        editor.putInt(name, `val`)
        editor.commit()
    }

    //添加activity
    fun addActivity(activity: Activity) {
        // 判断当前集合中不存在该Activity
        if (!activities!!.contains(activity)) {
            activities!!.add(activity)
        }
    }

    //销毁单个activity
    fun removeActivity(activity: Activity) {
        //判断当前集合中存在该Activity
        if (activities!!.contains(activity)) {
            activities!!.remove(activity)
        }
    }

    //销毁所有activity
    fun finishAllActivity() {
        for (activity in activities!!) {
            activity?.finish()
        }
    }

    companion object {
        private val PREF_NAME = "eshop-game"
        //获取应用程序上下文对象
        var context: MyApplication? = null
            private set
    }
}