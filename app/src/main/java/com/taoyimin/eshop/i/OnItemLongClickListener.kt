package com.taoyimin.eshop.i

/**
 * Created by Tao Yimin on 2019/5/10.
 */
interface OnItemLongClickListener<T> {

    fun onItemLongClick(obj: T, position: Int): Boolean

}