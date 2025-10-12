package com.marries.leetcode.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marries.leetcode.databinding.ItemPageBinding

class seven : Fragment() {

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
        mBinding.tittle.setText("7. 整数反转 (简单)")
        mBinding.description.setText(
            "给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。\n注意:\n" +
                    "假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。\n" 
        )
        mBinding.eg.text = "输入: 123\n输出: 321"
        mBinding.answer1.text = "var n : Long = 0\n" +
                "    var num = x\n" +
                "    while (num != 0) {\n" +
                "        n = n * 10 + num % 10\n" +
                "        num /= 10\n" +
                "    }\n" +
                "    return if (n > Int.MAX_VALUE || n < Int.MIN_VALUE) 0 else n.toInt()"
    }
}

fun reverse(x: Int): Int {
    var n : Long = 0
    var num = x
    while (num != 0) {
        println("n:$n")
        n = n * 10 + num % 10
        println("n:$n,num:$num")
        num /= 10
        println("num:$num")
    }
    return if (n > Int.MAX_VALUE || n < Int.MIN_VALUE) 0 else n.toInt()
}

fun main(args: Array<String>) {
    print(reverse(-4565))
}

