package com.programmers.Programmers

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class Second  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    init {
        solution("11");
        solution2(intArrayOf(123))
        solution3(intArrayOf(1,2,3,4))
        Log.e("ddd", solution2(intArrayOf(123)).toString())
        solution4(32423)


    }

    fun solution(s: String): Int {
        var answer: Int = 0
        fun solution(s: String): Int {
            var strNum = s
            strNum = strNum.replace("zero", "0")
            strNum = strNum.replace("one", "1")
            strNum = strNum.replace("two", "2")
            strNum = strNum.replace("three", "3")
            strNum = strNum.replace("four", "4")
            strNum = strNum.replace("five", "5")
            strNum = strNum.replace("six", "6")
            strNum = strNum.replace("seven", "7")
            strNum = strNum.replace("eight", "8")
            strNum = strNum.replace("nine", "9")

            val answer = strNum.toInt()
            return answer
        }

        return answer
    }

    // runTime error
    fun solutionError(s: String): Int {
        var strNum = s

        strNum = strNum.replace("one", "1")
            .replace("two", "2")
            .replace("three", "3")
            .replace("four", "4")
            .replace("five", "5")
            .replace("six", "6")
            .replace("seven", "7")
            .replace("eight", "8")
            .replace("nine", "9")

        val answer = strNum.toInt()

        return answer
    }

    /** n+n+1, n+n+2 ,,,,,
     */

    fun solution2(numbers: IntArray): IntArray {
        val list = numbers.toList()
        return list.withIndex().flatMap { i -> list.withIndex().map { j -> i to j } }
            .filter { it.first.index != it.second.index }
            .map { it.first.value + it.second.value }
            .toSortedSet()
            .toIntArray()
    }

        // ????????? ?????? ????????? ?????????
    fun solution3(arr: IntArray): Double    {
        Log.e("??????", arr.average().toString())
        return arr.average()
    }

    fun solution4(n: Int): Int {
        for (num: Int in 2..n) {
            if (n % num == 1) return num;
        }
        return 1;
    }


}

