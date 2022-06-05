package com.programmers.Programmers

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import java.util.Map

class MainActivity() : AppCompatActivity() {

    val mKotlinFunction = KotlinFunction();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mKotlinFunction.GroupBy()
        mKotlinFunction.AsSequence()
        mKotlinFunction.Map()

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




