package com.programmers.Programmers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity() : AppCompatActivity() {

    val mKotlinFunction = KotlinFunction();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mKotlinFunction.GroupBy()
        mKotlinFunction.AsSequence()
        mKotlinFunction.Map()
        mKotlinFunction.Filter()
        mKotlinFunction.GroupingBy()
    }

     init {
        val UserListStr: ArrayList<String> =  ArrayList()
        val ReportStr: ArrayList<String> = ArrayList()
        UserListStr.add("muzi")
        UserListStr.add("frodo")
        UserListStr.add("apeach")
        UserListStr.add("neo")
        ReportStr.add("muzi frodo")
        ReportStr.add("apeach frodo")
        ReportStr.add("frodo neo")
        ReportStr.add("muzi neo")
        ReportStr.add("apeach muzi ")
        solution(UserListStr,ReportStr,2)

    }



        private fun solution(id_list: ArrayList<String>, report: ArrayList<String>, k: Int): IntArray =
       //report를 split 을 기준으로 쪼갠다.
        report.map { it.split(" ") }
            .groupBy { it[1] }
            .asSequence()
            .map { it.value.distinct() }
            .filter { it.size >= k }
            .flatten()
            .map { it[0] }
            .groupingBy { it }
            .eachCount()
            .run { id_list.map{ getOrDefault(it,0) }.toIntArray()}
}


class Solution {
    fun solution(lottos: IntArray, winNums: IntArray): IntArray {
        return intArrayOf(
            (lottos.size.plus(1)) - lottos.filter { winNums.contains(it) || it == 0 }.size,
            (lottos.size.plus(1)) - lottos.filter(winNums::contains).size
        ).map { if (it > 6) it - 1 else it }.toIntArray()
    }
}



class Solutio1n {
    fun solution(lottos: IntArray, win_nums: IntArray): MutableList<Int> {

        val answer : MutableList<Int> = ArrayList()
        val msumSize = lottos.size + win_nums.size

        val joinArray : MutableList<IntArray> = ArrayList()
        joinArray.addAll(listOf(lottos))
        joinArray.addAll(listOf(win_nums))
        val maxList = removeItem(joinArray,0)
        val min = msumSize - joinArray.distinct().size
        val max = msumSize - maxList.size

        when(min) {
            1 ->  answer.add(0,1)
            2 ->  answer.add(0,2)
            3 ->  answer.add(0,3)
            4 ->  answer.add(0,4)
            5 ->  answer.add(0,5)
            else -> answer.add(0,6)
        }

        when(min) {
            1 ->  answer.add(1,1)
            2 ->  answer.add(1,2)
            3 ->  answer.add(1,3)
            4 ->  answer.add(1,4)
            5 ->  answer.add(1,5)
            else -> answer.add(1,6)
        }


        return answer
    }

    fun removeItem(array: MutableList<IntArray>, index: Int): Array<IntArray?> {
        val result = arrayOfNulls<IntArray>(array.lastIndex)
        System.arraycopy(array, 0, result, 0, index)
        if (array.size != index) {
            System.arraycopy(array, index + 1, result, index, array.lastIndex - index)
        }
        return result
    }
}




