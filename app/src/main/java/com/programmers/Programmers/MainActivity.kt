package com.programmers.Programmers

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import java.security.acl.Group

class MainActivity() : AppCompatActivity() {

    lateinit var UserListStr: ArrayList<String>
    lateinit var ReportStr: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GroupBy();
        UserListStr =  ArrayList()
        ReportStr = ArrayList()
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


    private fun GroupBy() {
        val GrupByList = listOf("코","코틀","코틀린")
        val map = GrupByList.groupBy({ "코" },{ it })
        val map1 = GrupByList.groupBy({ it },{ "코" })
        val map2 = GrupByList.groupBy { it }
        val map3 = GrupByList.groupBy { "코" }
        val map4 = GrupByList.groupBy { "틀" }
        val map5 = GrupByList.groupBy { "코틀" }
        val map6 = GrupByList.groupBy{ it.length}
        val asSequenceFormList = GrupByList.asSequence()
        println(map)
        println(map1)
        println(map2)
        println(map3)
        println(map4)
        println(map5)
        println(map6)
        println("asSequence $asSequenceFormList")


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
            .run { id_list.map {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                getOrDefault(it, 0)
            } else {
                TODO("VERSION.SDK_INT < N")
            }
            }.toIntArray() }
}







