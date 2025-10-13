package com.marries.commonlib.mode.autoregister

import java.util.ServiceLoader

/**
 * 用于在主App注册，进行界面跳转
 */
interface IAutoRegisterInApp {
    fun getName(): String
    fun getJavaClass(): Class<out Any>
}

/**
 * 获取所有标记的模块列表
 */
fun getModuleList(): List<IAutoRegisterInApp> =
    ServiceLoader.load(IAutoRegisterInApp::class.java).toList()