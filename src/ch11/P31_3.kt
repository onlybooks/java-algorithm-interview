package ch11

class P31_3 {
    fun numJewelsInStones(J: String, S: String): Int {
        var count = 0
        val freqs: MutableSet<Char> = HashSet()

        // 보석(J) 종류 저장
        for (j in J.toCharArray())
            freqs.add(j)
        // 돌(S)이 보석(J)인 경우 +1
        for (s in S.toCharArray())
            if (freqs.contains(s)) count++
        return count
    }
}