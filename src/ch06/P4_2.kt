package ch06

class P4_2 {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        // 각 단어별 개수가 저장될 키-값 맵
        val counts: MutableMap<String, Int> = mutableMapOf()

        // 전처리 작업 후 단어 목록을 배열로 저장
        val words = paragraph.replace("\\W+".toRegex(), " ").toLowerCase().trim().split("\\s+")

        for (w in words) {
            // 금지된 단어가 아닌 경우 개수 처리
            if (!banned.contains(w)) {
                // 존재하지 않는 단어라면 기본값을 0으로 지정
                // 추출한 값에 +1하여 저장
                counts[w] = counts.getOrDefault(w, 0) + 1
            }
        }
        // 가장 흔하게 등장하는 단어 추출
        return counts.maxBy { it.value }!!.key
    }
}