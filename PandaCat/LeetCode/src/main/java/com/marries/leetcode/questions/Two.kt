package com.marries.leetcode.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marries.leetcode.databinding.ItemPageBinding

class two : Fragment() {

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
        mBinding.tittle.setText("2. 两数相加 (中等)")
        mBinding.description.setText(
            "给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。\n" +
                    "\n" + "如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。\n" + "\n" + "您可以假设除了数字 0 之外，这两个数都不会以 0 开头。\n"
        )
        mBinding.eg.setText(
            "输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)\n" +
                    "输出：7 -> 0 -> 8\n" +
                    "原因：342 + 465 = 807"
        )
        mBinding.answer1.setText("fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {\n" +
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

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var ll1 = l1
    var ll2 = l2
    val dummyHead = ListNode(-1)
    var pre: ListNode? = dummyHead
    var t = 0
    while (ll1 != null || ll2 != null || t != 0) {
        if (ll1 != null) {
            t += ll1.`val`
            ll1 = ll1.next
        }
        if (ll2 != null) {
            t += ll2.`val`
            ll2 = ll2.next
        }
        pre!!.next = ListNode(t % 10)
        pre = pre!!.next
        t /= 10
    }

    return dummyHead.next
}

fun main(args: Array<String>) {
    var l10 = ListNode(2)
    var l11 = ListNode(4)
    var l12 = ListNode(3)
    l10.next = l11
    l11.next = l12

    var l20 = ListNode(5)
    var l21 = ListNode(6)
    var l22 = ListNode(4)
    l20.next = l21
    l21.next = l22

    var l = addTwoNumbers(l10, l20)
    do {
        print(l?.`val`)
        l = l?.next
    } while (null != l)
}