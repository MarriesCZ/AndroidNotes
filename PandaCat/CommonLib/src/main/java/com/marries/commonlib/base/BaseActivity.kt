package com.marries.commonlib.base

import androidx.appcompat.app.AppCompatActivity
import com.marries.commonlib.mode.autoregister.IAutoRegisterInApp

abstract class BaseActivity: AppCompatActivity(), IAutoRegisterInApp {

    abstract override fun getName(): String

    override fun getJavaClass(): Class<out Any> = this::class.java
}