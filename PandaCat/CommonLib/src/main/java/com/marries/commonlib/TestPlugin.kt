package com.marries.commonlib

import android.app.Activity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RelativeLayout
import androidx.core.view.isVisible
import com.marries.commonlib.databinding.FloatListButtonBinding
import com.marries.commonlib.databinding.FloatingbuttonBinding

class TestPlugin(private val mActivity: Activity) {
    val mBinding by lazy(LazyThreadSafetyMode.NONE) {
        FloatingbuttonBinding.inflate(mActivity.layoutInflater)
    }
    var mOnMainKeyClick = {
        mBinding.buttonList.visibility = if (mBinding.buttonList.isVisible) View.GONE else View.VISIBLE
    }
    var mOnMainKeyLongClick: () -> Boolean = {
        mBinding.root.isVisible = false
        true
    }

    init {
        val layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        mActivity.window.addContentView(mBinding.root, layoutParams)
        val adapter = ArrayAdapter<String?>(mActivity, R.layout.floatingbutton, 0)
        mBinding.buttonList.setAdapter(adapter)
        mBinding.mainKey.apply {
            setOnClickListener { mOnMainKeyClick() }
            setOnLongClickListener { mOnMainKeyLongClick() }
        }
    }

    fun addDefaultButton(text: String?, id: Int, onClick: (view: View) -> Unit = {}): View {
        val defaultButton = FloatListButtonBinding.inflate(mActivity.layoutInflater)
        defaultButton.root.apply {
            this.text = text
            setId(id)
            setOnClickListener {
                onClick(it)
            }
        }
        return addButton(defaultButton.root)
    }

    private fun addButton(button: View): View {
        mBinding.buttonList.addFooterView(button)
        return button
    }
}
