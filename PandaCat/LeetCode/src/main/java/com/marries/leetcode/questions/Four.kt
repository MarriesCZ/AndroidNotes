package com.marries.leetcode.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marries.leetcode.databinding.ItemPageBinding

class four : Fragment() {

    private lateinit var mBinding: ItemPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = ItemPageBinding.inflate(inflater);
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.tittle.setText("4. 寻找两个正序数组的中位数 (困难)")
        mBinding.description.setText(
            "给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。\n" +
                    "\n" +
                    "进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？\n" +
                    "\n"
        )
        mBinding.eg.setText(
            "输入：nums1 = [1,3], nums2 = [2]\n" +
                    "输出：2.00000\n" +
                    "解释：合并数组 = [1,2,3] ，中位数 2"
        )
        mBinding.answer1.setText("fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {\n" +
                "    val medianIndex1 = (nums1.lastIndex + nums2.lastIndex + 1) / 2\n" +
                "    val medianIndex2 = (nums1.lastIndex + nums2.lastIndex + 2) / 2\n" +
                "    var p1 = 0\n" +
                "    var p2 = 0\n" +
                "    var median = 0\n" +
                "    for (i in 0 until medianIndex2 + 1) {\n" +
                "        val value = when {\n" +
                "            p1 >= nums1.size -> nums2[p2++]\n" +
                "            p2 >= nums2.size -> nums1[p1++]\n" +
                "            nums1[p1] > nums2[p2] -> nums2[p2++]\n" +
                "            else -> nums1[p1++]\n" +
                "        }\n" +
                "        median += when{\n" +
                "            i == medianIndex1 -> value\n" +
                "            i == medianIndex2 -> value\n" +
                "            else -> 0\n" +
                "        }\n" +
                "    }\n" +
                "    return median / (medianIndex2 - medianIndex1 + 1.0)\n" +
                "}")
    }
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val medianIndex1 = (nums1.lastIndex + nums2.lastIndex + 1) / 2
    val medianIndex2 = (nums1.lastIndex + nums2.lastIndex + 2) / 2
    var p1 = 0
    var p2 = 0
    var median = 0
    for (i in 0 until medianIndex2 + 1) {
        val value = when {
            p1 >= nums1.size -> nums2[p2++]
            p2 >= nums2.size -> nums1[p1++]
            nums1[p1] > nums2[p2] -> nums2[p2++]
            else -> nums1[p1++]
        }
        median += when{
            i == medianIndex1 -> value
            i == medianIndex2 -> value
            else -> 0
        }
    }
    return median / (medianIndex2 - medianIndex1 + 1.0)
}

fun main(args: Array<String>) {
    print(findMedianSortedArrays(intArrayOf(1), intArrayOf(1, 2)))
}