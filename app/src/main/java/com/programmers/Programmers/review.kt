package com.programmers.Programmers

class review {

    /**
     * GroupBy는 개발자가 선언한 조건에 따라 해당 List에서 항목들을 그룹화 한다.
     * 아래 소스는 kotlin공식 문서를 참조한다
     * 1, words 라는 list 에 입값을 을 입력한다.
     * 2, words 에 있는 항목들을 각 항목의 길이 별로 groupBy 해준다.
     */

    fun GroupBy() {
        val words = listOf("a", "abc", "ab", "def", "abcd")
        val byLength = words.groupBy { it.length }

        println(byLength.keys) // [1, 3, 2, 4]
        println(byLength.values) // [[a], [abc, def], [ab], [abcd]]

        val mutableByLength: MutableMap<Int, MutableList<String>> = words.groupByTo(mutableMapOf()) { it.length }
        println("mutableByLength == byLength is ${mutableByLength == byLength}") // true
    }

}