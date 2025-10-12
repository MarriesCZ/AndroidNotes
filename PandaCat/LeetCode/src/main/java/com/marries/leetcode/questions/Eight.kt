package com.marries.leetcode.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marries.leetcode.databinding.ItemPageBinding
import java.util.regex.Pattern


class eight : Fragment() {

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
        mBinding.tittle.setText("8. 字符串转换整数 (中等)")
        mBinding.description.text = "请你来实现一个 atoi 函数，使其能将字符串转换成整数。\n" +
                "\n" +
                "首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：\n" +
                "\n" +
                "如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。\n" +
                "假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。\n" +
                "该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。\n" +
                "注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。\n" +
                "\n" +
                "在任何情况下，若函数不能进行有效的转换时，请返回 0 。\n" +
                "\n" +
                "提示：\n" +
                "\n" +
                "本题中的空白字符只包括空格字符 ' ' 。\n" +
                "假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。"
        mBinding.eg.text = "输入: \"   -42\"\n" +
                "输出: -42\n" +
                "解释: 第一个非空白字符为 '-', 它是一个负号。\n" +
                "     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。\n"
        mBinding.answer1.text = "fun myAtoi(str: String): Int {\n" +
                "    val p = Pattern.compile(\"^[\\\\+\\\\-]?\\\\d+\")\n" +
                "    val m = p.matcher(str.trim { it <= ' ' })\n" +
                "    return if (m.find()) {\n" +
                "        val matchResult = m.group().trim()\n" +
                "        println(matchResult)\n" +
                "        when {\n" +
                "            matchResult.toDouble() >= Int.MAX_VALUE -> Int.MAX_VALUE\n" +
                "            matchResult.toDouble() <= Int.MIN_VALUE -> Int.MIN_VALUE\n" +
                "            else -> matchResult.toInt()\n" +
                "        }\n" +
                "    } else {\n" +
                "        0\n" +
                "    }\n" +
                "}"
        mBinding.answer2.text = "fun myAtoii(str: String): Int {\n" +
                "    if (str.isEmpty()) return 0\n" +
                "\n" +
                "    val len = str.length\n" +
                "    var index = 0\n" +
                "    while (index < len && str[index] == ' ') {\n" +
                "        index++\n" +
                "    }\n" +
                "\n" +
                "    if (index == len) return 0\n" +
                "\n" +
                "    var sign = 1\n" +
                "    val firstChar = str[index]\n" +
                "    if (firstChar == '+') {\n" +
                "        index++\n" +
                "    } else if (firstChar == '-') {\n" +
                "        sign = -1\n" +
                "        index++\n" +
                "    } else if (firstChar > '9' || firstChar < '0') {\n" +
                "        return 0\n" +
                "    }\n" +
                "\n" +
                "    var res = 0\n" +
                "    while (index < len) {\n" +
                "\n" +
                "        if (str[index] > '9' || str[index] < '0') {\n" +
                "            break\n" +
                "        }\n" +
                "        val currNum = str[index] - '0'\n" +
                "        if (res > Int.MAX_VALUE / 10 || (res == Int.MAX_VALUE / 10 && currNum > 7)) {\n" +
                "            return Int.MAX_VALUE\n" +
                "        }\n" +
                "        if (res < Int.MIN_VALUE / 10 || (res == Int.MIN_VALUE / 10 && currNum > 8)) {\n" +
                "            return Int.MIN_VALUE\n" +
                "        }\n" +
                "        res = res * 10 + sign * currNum\n" +
                "        index++\n" +
                "    }\n" +
                "\n" +
                "    return res\n" +
                "}"
    }
}

fun myAtoi(str: String): Int {
    val p = Pattern.compile("^[\\+\\-]?\\d+")
    val m = p.matcher(str.trim { it <= ' ' })
    return if (m.find()) {
        val matchResult = m.group().trim()
        println(matchResult)
        when {
            matchResult.toDouble() >= Int.MAX_VALUE -> Int.MAX_VALUE
            matchResult.toDouble() <= Int.MIN_VALUE -> Int.MIN_VALUE
            else -> matchResult.toInt()
        }
    } else {
        0
    }
}

fun myAtoii(str: String): Int {
    if (str.isEmpty()) return 0

    val len = str.length
    var index = 0
    while (index < len && str[index] == ' ') {
        index++
    }

    if (index == len) return 0

    var sign = 1
    val firstChar = str[index]
    if (firstChar == '+') {
        index++
    } else if (firstChar == '-') {
        sign = -1
        index++
    } else if (firstChar > '9' || firstChar < '0') {
        return 0
    }

    var res = 0
    while (index < len) {

        if (str[index] > '9' || str[index] < '0') {
            break
        }
        val currNum = str[index] - '0'
        if (res > Int.MAX_VALUE / 10 || (res == Int.MAX_VALUE / 10 && currNum > 7)) {
            return Int.MAX_VALUE
        }
        if (res < Int.MIN_VALUE / 10 || (res == Int.MIN_VALUE / 10 && currNum > 8)) {
            return Int.MIN_VALUE
        }
        res = res * 10 + sign * currNum
        index++
    }

    return res
}


fun main(args: Array<String>) {
    print(myAtoi("               -42548641231531asdadsfgsadfsf"))
}

