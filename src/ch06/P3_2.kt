package ch06

class P3_2 {
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        // 문자 로그를 저장할 문자 리스트
        val letterList = mutableListOf<String>()
        // 숫자 로그를 저장할 숫자 리스트
        val digitList = mutableListOf<String>()

        for (log in logs) {
            // 로그 종류 확인 후 숫자 로그라면 숫자 리스트에 삽입
            if (Character.isDigit(log.split(" ")[1][0])) {
                digitList.add(log)
            } else {
                // 숫자 로그가 아니라면 문자 리스트에 삽입
                letterList.add(log)
            }
        }

        // 문자 리스트 정렬 진행
        letterList.sortWith(Comparator { s1: String, s2: String ->
            // 식별자와 식별자 외 나머지 부분, 이렇게 두 부분으로 나눈다.
            val s1x = s1.split(" ", limit = 2)
            val s2x = s2.split(" ", limit = 2)

            // 문자 로그 사전순 비교
            val compared = s1x[1].compareTo(s2x[1])
            // 문자가 동일한 경우 식별자 비교하여 먼저 리턴
            if (compared == 0) {
                s1x[0].compareTo(s2x[0])
            } else {
                // 비교 대상의 순서가 동일한 경우 0, 순서가 앞인 경우 1, 순서가 뒤인 경우 -1이 된다.
                compared
            }
        })

        // 문자 리스트 뒤로 숫자 리스트를 이어 붙인다.
        // 숫자 로그는 '입력 순서대로'라는 제약 조건이 있으므로 따로 정렬하지 않는다.
        letterList.addAll(digitList)

        // 리스트를 String 배열로 변환해 리턴한다.
        return letterList.toTypedArray()
    }
}