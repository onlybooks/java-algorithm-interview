package ch12

class P36_2 {
    fun letterCombinations(digits: String): List<String> {
        // 결과 저장 리스트 선언
        val result: MutableList<String> = mutableListOf()
        // 예외 처리
        if (digits.isEmpty())
            return result

        // 번호로 조합 가능한 문자 목록 구성
        val dic: MutableMap<Char, List<Char>> = mutableMapOf(
                '0' to mutableListOf(),
                '1' to mutableListOf(),
                '2' to mutableListOf('a', 'b', 'c'),
                '3' to mutableListOf('d', 'e', 'f'),
                '4' to mutableListOf('g', 'h', 'i'),
                '5' to mutableListOf('j', 'k', 'l'),
                '6' to mutableListOf('m', 'n', 'o'),
                '7' to mutableListOf('p', 'q', 'r', 's'),
                '8' to mutableListOf('t', 'u', 'v'),
                '9' to mutableListOf('w', 'x', 'y', 'z')
        )

        fun dfs(index: Int, path: StringBuilder) {
            // 끝까지 탐색했으면 결과 저장하고 리턴
            if (path.length == digits.length) {
                result.add(path.toString())
                return
            }

            // 현재 자리 숫자에 해당하는 모든 문자열 탐색
            for (c in dic[digits[index]]!!) {
                // 현재 자리 +1, 지금까지 구성된 문자열 path 이용 재귀 DFS
                dfs(index + 1, StringBuilder(path).append(c))
            }
        }

        // 현재 자리 0, 빈 문자열 이용 DFS 시작
        dfs(0, StringBuilder())
        return result
    }
}