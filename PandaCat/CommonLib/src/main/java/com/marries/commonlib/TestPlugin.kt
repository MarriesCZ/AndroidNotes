package com.marries.commonlib

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import androidx.core.view.isVisible
import com.marries.commonlib.databinding.FloatListButtonBinding
import com.marries.commonlib.databinding.FloatingbuttonBinding

class TestPlugin(private val mActivity: Activity) {
    val mBinding by lazy(LazyThreadSafetyMode.NONE) {
        FloatingbuttonBinding.inflate(mActivity.layoutInflater)
    }

    // 高度配置（单位：dp）
    private companion object {
        const val ITEM_HEIGHT_DP = 56
        const val MAIN_BUTTON_SIZE_DP = 56
    }

    var mOnMainKeyClick = {
        mBinding.buttonList.visibility = if (mBinding.buttonList.isVisible) View.GONE else View.VISIBLE
    }
    var mOnMainKeyLongClick: () -> Boolean = {
        mBinding.root.isVisible = false
        true
    }

    init {
        // 设置浮动按钮布局参数
        val layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)

        // 添加到窗口
        mActivity.window.addContentView(mBinding.root, layoutParams)

        // 设置主按钮大小
        mBinding.mainKey.layoutParams?.apply {
            width = dpToPx(MAIN_BUTTON_SIZE_DP)
            height = dpToPx(MAIN_BUTTON_SIZE_DP)
        }

        // 设置列表适配器（固定高度）
        val adapter = object : ArrayAdapter<String?>(mActivity, R.layout.floatingbutton, 0) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                view.layoutParams = view.layoutParams?.apply {
                    height = dpToPx(ITEM_HEIGHT_DP)
                } ?: ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    dpToPx(ITEM_HEIGHT_DP)
                )
                return view
            }
        }

        mBinding.buttonList.adapter = adapter
        mBinding.mainKey.apply {
            setOnClickListener { mOnMainKeyClick() }
            setOnLongClickListener { mOnMainKeyLongClick() }
        }
    }

    fun addButton(text: String?, onClick: (view: View) -> Unit = {}): View {
        val button = FloatListButtonBinding.inflate(mActivity.layoutInflater).root
        button.apply {
            this.text = text
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dpToPx(ITEM_HEIGHT_DP))
            setOnClickListener { onClick(it) }
        }
        mBinding.buttonList.addFooterView(button)
        return button
    }

    // 资源清理
    fun detach() {
        (mBinding.root.parent as? ViewGroup)?.removeView(mBinding.root)
    }

    // dp转px
    private fun dpToPx(dp: Int): Int {
        val density = mActivity.resources.displayMetrics.density
        return (dp * density).toInt()
    }
}
