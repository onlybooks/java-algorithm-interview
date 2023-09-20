package ch06

import kotlin.collections.ArrayList

class P5_2 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val results: MutableMap<String, MutableList<String>> = mutableMapOf()

        for (s in strs) {
            // 문자열 정렬
            val key = s.toCharArray().sorted().joinToString("");
            // 만약 기존에 없던 키라면 빈 리스트를 삽입
            results.getOrPut(key) { mutableListOf() }
            // 키에 해당하는 리스트에 추가
            results[key]!!.add(s)
        }
        return ArrayList<List<String>>(results.values)
    }
}