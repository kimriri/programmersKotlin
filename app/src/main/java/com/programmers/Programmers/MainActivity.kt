package com.programmers.Programmers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*
import java.util.regex.Pattern
import kotlin.collections.ArrayList

class MainActivity() : AppCompatActivity() {

    val mKotlinFunction = KotlinFunction();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list1 = listOf(44, 1, 0, 0, 31, 25)
        val list2 = listOf(31, 10, 45, 1, 6, 19)
        Solution2(list1, list2)
       // mKotlinFunction.GroupBy()
       // mKotlinFunction.AsSequence()
       // mKotlinFunction.Map()
       // mKotlinFunction.Filter()
       // mKotlinFunction.GroupingBy()

        solution("qwedf")
    }

     init {
        val UserListStr: ArrayList<String> =  ArrayList()
        val ReportStr: ArrayList<String> = ArrayList()
//        UserListStr.add("muzi")
//        UserListStr.add("frodo")
//        UserListStr.add("apeach")
//        UserListStr.add("neo")
//        ReportStr.add("muzi frodo")
//        ReportStr.add("apeach frodo")
//        ReportStr.add("frodo neo")
//        ReportStr.add("muzi neo")
//        ReportStr.add("apeach muzi ")
//        solution(UserListStr,ReportStr,2)
         solution3("..  23ㅂㅈ슏ㄱㅅㅈㅍ댓" +
                 "ㄷㅅㅍ,ㅑ34224ㄹㅁㄴㅇㄹㄷ3#|,,..")

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


private fun Solution2 (lottos: List<Int>, winNums: List<Int>): IntArray{
        return intArrayOf(
            (lottos.size.plus(1)) - lottos.filter { winNums.contains(it) || it == 0 }.size,
            (lottos.size.plus(1)) - lottos.filter(winNums::contains).size
        ).map {
            if (it > 6)
                it - 1
            else
                it
        }.toIntArray()

}

//1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
//2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
//3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
//4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
//5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
//6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
//7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

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

        when(max) {
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



    fun solution3(new_id: String) : String {
        return new_id
            .stageOne()
            .stageTwo()
            .stageThree()
            .stageFour()
            .stageFive()
            .stageSix()
            .stageSeven()
    }

            fun String.stageOne() = this.lowercase(Locale.getDefault())
            fun String.stageTwo() = this.filter {
                it.isLetter()
                    .or(it.isDigit())
                    .or(it == '.')
                    .or(it == '_')
                    .or(it == '-') }
            fun String.stageThree() = this.replace(Regex("[.]+"), ".")
            fun String.stageFour() = this.filterIndexed { index, c -> (index != 0 || c != '.') && (index != this.lastIndex || c != '.') }
            fun String.stageFive() = if (this == "") this + "a" else this
            fun String.stageSix() = if (this.length >= 16) this.substring(0..14).filterIndexed { index, c -> !(index == 14 && c == '.')} else this
            fun String.stageSeven() = if (this.length <= 2) this + this.last().toString().repeat(3 - this.length) else this





        //가운데 글자 가져 오기
    fun solution(s: String): String {

        val a = s.length
        var answer = ""
        if (a % 2 == 0) {
           val A =  a/2
            answer = s[A-1].toString() + s[A].toString()

        }
        if (a % 2 != 0) {
            val A =  a/2
            answer = s[A].toString()



        }
            return answer
        }

//가운데 글자 가져 오기
class Solution {
    fun solution(s: String) =
        with(s) { substring(length / 2 - 1 +
                (length % 2) .. length / 2) }
}

