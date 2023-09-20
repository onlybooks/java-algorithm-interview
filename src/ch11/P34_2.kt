package ch11

class P34_2 {
    // **이 문제는 프로그래머스에서 코틀린 풀이를 지원하지 않으므로 이 코드 추후 삭제**
    fun solution(participant: Array<String>, completion: Array<String>): String {
        val m: MutableMap<String, Int> = mutableMapOf()
        // 참여 선수 이름, 동명이인인 경우 +1 해시맵 삽입
        for (p in participant)
            m[p] = m.getOrDefault(p, 0) + 1

        // 완주 선수 이름 제거
        for (c in completion) {
            val left = m[c]!!
            if (left == 1) // 하나만 있는 경우 키 자체를 삭제
                m.remove(c)
            else
                m[c] = left - 1
        }
        // 남아 있는 유일한 키(이름) 리턴
        return m.entries.iterator().next().key
    }
}