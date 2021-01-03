package com.marries.module_leetcode.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marries.module_leetcode.databinding.ItemPageBinding

class six : Fragment() {

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
        mBinding.tittle.setText("6. N 字形变换 (中等)")
        mBinding.description.setText(
            "将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。\n" +
                    "\n" +
                    "比如输入字符串为 \"LEETCODEISHIRING\" 行数为 3 时，排列如下：\n" +
                    "\n" +
                    "L   C   I   R\n" +
                    "E T O E S I I G\n" +
                    "E   D   H   N\n" +
                    "之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：\"LCIRETOESIIGEDHN\"。\n" +
                    "\n"
        )
        mBinding.eg.setText(
            "输入: s = \"LEETCODEISHIRING\", numRows = 4\n" +
                    "输出: \"LDREOEIIECIHNTSG\"\n" +
                    "解释:\n" +
                    "\n" +
                    "L     D     R\n" +
                    "E   O E   I I\n" +
                    "E C   I H   N\n" +
                    "T     S     G\n" +
                    "\n"
        )
        mBinding.answer1.setText("fun convert(s: String, numRows: Int): String {\n" +
                "    if (numRows >= s.length || numRows == 1) return s\n" +
                "    val maxGap = 2 * (numRows - 1)\n" +
                "    var newList = StringBuilder()\n" +
                "    for (i in 0 until numRows) {\n" +
                "        var cursor = i\n" +
                "        var change = 1\n" +
                "        while (cursor < s.length) {\n" +
                "            newList.append(s[cursor])\n" +
                "            cursor += when (i) {\n" +
                "                0 -> maxGap\n" +
                "                numRows - 1 -> maxGap\n" +
                "                else -> when (change) {\n" +
                "                    1 -> maxGap - 2 * i\n" +
                "                    else -> 2 * i\n" +
                "                }\n" +
                "            }\n" +
                "            change *= -1\n" +
                "        }\n" +
                "    }\n" +
                "    return newList.toString()\n" +
                "}")
    }
}

fun convert(s: String, numRows: Int): String {
    if (numRows >= s.length || numRows == 1) return s
    val maxGap = 2 * (numRows - 1)
    var newList = StringBuilder()
    for (i in 0 until numRows) {
        var cursor = i
        var change = 1
        while (cursor < s.length) {
            newList.append(s[cursor])
            cursor += when (i) {
                0 -> maxGap
                numRows - 1 -> maxGap
                else -> when (change) {
                    1 -> maxGap - 2 * i
                    else -> 2 * i
                }
            }
            change *= -1
        }
    }
    return newList.toString()
}

fun main(args: Array<String>) {
    print(convert("LEETCODEISHIRING", 3))
    // "LCIRETOESIIGEDHN"
}

