package com.marries.leetcode.questions

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marries.leetcode.R
import com.marries.leetcode.databinding.ItemPageBinding

class one : Fragment() {

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
        mBinding.tittle.setText("1. 两数之和 (简单)")
        mBinding.description.setText(Html.fromHtml(getString(R.string.first)))
        mBinding.eg.setText(
            "给定 nums = [2, 7, 11, 15], target = 9\n" + "\n" + "因为 nums[0] + nums[1] = 2 + 7 = 9\n" + "所以返回 [0, 1]\n"
        )
        mBinding.answer1.setText("fun twoSum(nums: IntArray, target: Int): IntArray {\n" +
                "    val index = IntArray(2)\n" +
                "\n" +
                "    val hashMap = HashMap<Int, Int>()\n" +
                "\n" +
                "    for (i in nums.indices) {\n" +
                "        if (hashMap.containsKey(nums[i])) {\n" +
                "            index[0] = hashMap[nums[i]]!!\n" +
                "            index[1] = i\n" +
                "            return index\n" +
                "        }\n" +
                "        hashMap[target - nums[i]] = i\n" +
                "    }\n" +
                "    return index\n" +
                "}")
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val index = IntArray(2)

    val hashMap = HashMap<Int, Int>()

    for (i in nums.indices) {
        if (hashMap.containsKey(nums[i])) {
            index[0] = hashMap[nums[i]]!!
            index[1] = i
            return index
        }
        hashMap[target - nums[i]] = i
    }
    return index
}

fun main(args: Array<String>) {
    for (item in twoSum(intArrayOf(1, 5, 13, 8, 9, 2), 11)) {
        println(item)
    }
}