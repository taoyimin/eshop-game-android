package com.taoyimin.eshop.i

/**
 * Created by Tao Yimin on 2019/5/10.
 */
interface OnItemClickListener<T> {

    fun onItemClick(obj: T, position: Int)

}