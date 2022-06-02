package com.programmers.Programmers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class KotlinFunction : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GroupBy()
    }

    // GroupBy
    private fun GroupBy() {
        val GrupByList = listOf("코", "코틀", "코틀린")
        val map = GrupByList.groupBy({ "코" }, { it })
        val map1 = GrupByList.groupBy({ it }, { "코" })
        val map2 = GrupByList.groupBy { it }
        val map3 = GrupByList.groupBy { "코" }
        val map4 = GrupByList.groupBy { "틀" }
        val map5 = GrupByList.groupBy { "코틀" }
        val map6 = GrupByList.groupBy { it.length }
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

}