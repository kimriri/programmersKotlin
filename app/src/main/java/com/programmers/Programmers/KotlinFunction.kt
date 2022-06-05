package com.programmers.Programmers

import kotlin.system.exitProcess


class KotlinFunction {

   /**
    * 출력 결과
    * {코=[코, 코틀, 코틀린]}
    * {코=[코], 코틀=[코], 코틀린=[코]}
    * {코=[코], 코틀=[코틀], 코틀린=[코틀린]}
    * {코=[코, 코틀, 코틀린]}
    * {틀=[코, 코틀, 코틀린]}
    * {코틀=[코, 코틀, 코틀린]}
    * {1=[코], 2=[코틀], 3=[코틀린]}
   */
     fun GroupBy() {
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


   /** .asSequence()는 데이터의 양이 많거나 용량이클때 사용하며
    * 양이 적거나 용량이 적을 경우 오히려 연산 속도가 덜어진다 ...
    * AsSequence0의 연산시간 9~7
    * AsSequence1의 연산시간 1~0
   */
   fun AsSequence() {
      val start0 = System.currentTimeMillis()

      val AsSequence0 = arrayOf('a','b','c').asSequence()
      println(AsSequence0.toString())
      val end0 = System.currentTimeMillis()
      val time0 = end0-start0
      println("연산 시간은 $time0 입니다.")

      val start1 = System.currentTimeMillis()
      val AsSequence1 = arrayOf('a','b','c',"A","B","C","가","나","다").asSequence()
      println(AsSequence1.toString())
      val end1 = System.currentTimeMillis()
      val time1 = end1-start1
      println("연산 시간은 $time1 입니다.")
   }

   /** 출력 결과  {A=1000, B=2000, (C, 3000)=4000} */
   fun Map() {
      val maps = arrayOf("A" to 1000,"B" to 2000, "C" to 3000 to 4000)
      println(maps.toMap())
   }
   /** 출력 결과
    * Filter는 2
    * Filter는 3
    * */
   fun Filter() {
      val Filter = listOf(1,2,3).filter { it != 1 }
      for(i in Filter.indices) {
         println("Filter는 ${Filter[i]}")
      }
   }
}