package ch24

class P96_2 {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        // 가장 먼저 로그에서 중복 제거
        val reportSet: Set<String> = report.toSet()
        // 피신고자 / 신고자 목록
        val reportLog: MutableMap<String, MutableList<String>> = mutableMapOf()
        for (set in reportSet) {
            // 앞: 신고자, 뒤: 피신고자
            val person = set.split(" ")
            // 첫 신고라면 빈 리스트 생성
            val list: MutableList<String> = reportLog.getOrDefault(person[1], mutableListOf())
            list.add(person[0]) // 신고자 목록에 삽입
            // 피신고자 / 신고자 목록 삽입
            reportLog[person[1]] = list
        }

        // 신고자 / 메일 수
        val mailCounts: MutableMap<String, Int> = mutableMapOf()
        for (log in reportLog) {
            // 신고자 목록이 k 이상일 때 신고자 목록 처리
            if (log.value.size >= k) {
                for (people in log.value) {
                    // 모든 신고자 메일 +1
                    mailCounts[people] = mailCounts.getOrDefault(people, 0) + 1
                }
            }
        }

        // 입력 배열을 메일 카운트 맵과 매칭하여 정답 구성
        return id_list
            .map { x: String -> mailCounts.getOrDefault(x, 0) }
            .toIntArray()
    }
}