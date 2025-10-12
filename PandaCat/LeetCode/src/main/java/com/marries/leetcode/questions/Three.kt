package com.marries.leetcode.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marries.leetcode.databinding.ItemPageBinding

class three : Fragment() {

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
        mBinding.tittle.setText("3. 无重复字符的最长子串 (中等)")
        mBinding.description.setText(
            "给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。"
        )
        mBinding.eg.setText(
            "输入: s = \"abcabcbb\"\n" +
                    "输出: 3 \n" +
                    "解释: 因为无重复字符的最长子串是 \"abc\"，所以其长度为 3。"
        )
        mBinding.answer1.setText("fun lengthOfLongestSubstring(s: String): Int {\n" +
                "    val enumchar = IntArray(255) { -1 }\n" +
                "    val sarr = s.toCharArray()\n" +
                "\n" +
                "    var start = 0\n" +
                "    var sublen = 0\n" +
                "    for (i in sarr.indices) {\n" +
                "        val index = sarr[i].toInt()\n" +
                "        if (enumchar[index] + 1 > start) {\n" +
                "            start = enumchar[index] + 1\n" +
                "        }\n" +
                "        if (i - start + 1 > sublen) {\n" +
                "            sublen = i - start + 1\n" +
                "        }\n" +
                "        enumchar[index] = i\n" +
                "    }\n" +
                "    return sublen\n" +
                "}")
        mBinding.answer2.setText("fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {\n" +
                "    var ll1 = l1\n" +
                "    var ll2 = l2\n" +
                "    val root = ListNode(0)\n" +
                "    var cursor = root\n" +
                "    var carry = 0\n" +
                "    while (ll1 != null || ll2 != null || carry != 0) {\n" +
                "        val l1Val = ll1?.`val` ?: 0\n" +
                "        val l2Val = ll2?.`val` ?: 0\n" +
                "        val sumVal = l1Val + l2Val + carry\n" +
                "        carry = sumVal / 10\n" +
                "        val sumNode = ListNode(sumVal % 10)\n" +
                "        cursor.next = sumNode\n" +
                "        cursor = sumNode\n" +
                "        if (ll1 != null) ll1 = ll1.next\n" +
                "        if (ll2 != null) ll2 = ll2.next\n" +
                "    }\n" +
                "    return root.next\n" +
                "}")
    }
}

fun lengthOfLongestSubstring(s: String): Int {
    val enumchar = IntArray(255) { -1 }
    val sarr = s.toCharArray()

    var start = 0
    var sublen = 0
    for (i in sarr.indices) {
        val index = sarr[i].toInt()
        if (enumchar[index] + 1 > start) {
            start = enumchar[index] + 1
        }
        if (i - start + 1 > sublen) {
            sublen = i - start + 1
        }
        enumchar[index] = i
    }
    return sublen
}

fun main(args: Array<String>) {
    print(lengthOfLongestSubstring("abaaaa"))
}