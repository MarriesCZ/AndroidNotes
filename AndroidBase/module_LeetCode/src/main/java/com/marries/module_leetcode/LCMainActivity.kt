package com.marries.module_leetcode

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.marries.module_leetcode.databinding.LcMainActivityBinding
import com.marries.module_leetcode.questions.*


class LCMainActivity : FragmentActivity() {

    private lateinit var mBinding: LcMainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = LcMainActivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        mBinding.pager.adapter = pagerAdapter
    }

    override fun onBackPressed() {
        if (mBinding.pager.currentItem == 0) {
            super.onBackPressed()
        } else {
            mBinding.pager.currentItem = mBinding.pager.currentItem - 1
        }
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = Companion.NUM_PAGES

        override fun createFragment(position: Int): Fragment {
            return when(position) {
                1 -> two()
                2 -> three()
                3 -> four()
                5 -> six()
                6 -> seven()
                7 -> eight()
                8 -> nine()
                9 -> ten()
                else -> one()
            }
        }
    }

    companion object {
        private const val NUM_PAGES = 10
    }
}