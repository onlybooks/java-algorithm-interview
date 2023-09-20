package ch16

class P63_3 {
    class TrieNode {
        // 단어 ID를 저장하는 변수, 초깃값은 의미 없는 값으로 선언
        var wordId: Int = -1

        // 트라이의 자식 노드들, 자식 노드는 알파벳의 개수인 최대 26개까지 가능
        var children: Array<TrieNode?> = arrayOfNulls(26)

        // 팰린드롬인 단어 ID를 목록으로 저장하는 변수, 팰린드롬 단어 ID 목록을 빈 값으로 초기화
        var palindromeWordIds: MutableList<Int> = mutableListOf()
    }

    class Trie {
        // 클래스 생성시 루트로 빈 트라이 노드 생성
        var root: TrieNode = TrieNode()

        // 인덱스를 받아서 팰린드롬 여부를 판별하는 메소드
        fun isPalindrome(str: String, start: Int, end: Int): Boolean {
            // 코틀린의 함수 파라미터는 읽기 전용이므로 별도 저장
            var start = start
            var end = end
            // 시작 지점이 종료지점보다 앞에 있으면 계속 반복
            while (start < end) {
                // 시작 지점은 증가하고 종료 지점은 감소하면서 문자가 일치하는지 확인, 한 번이라도 틀리면 false 리턴
                if (str[start++] != str[end--]) return false
            }
            // 한 번도 틀리지 않을 경우 팰린드롬이므로 true 리턴
            return true
        }

        // 단어 삽입
        fun insert(index: Int, word: String) {
            // 루트부터 시작
            var cur: TrieNode = root
            // 단어를 뒤집어서 트라이로 저장
            for (i in word.length - 1 downTo 0) {
                // 단어에서 해당 위치의 문자 추출
                val c = word[i]
                // 정방향으로 해당 위치까지 팰린드롬인 경우 단어의 인덱스 저장(그림에서 p로 표시)
                if (isPalindrome(word, 0, i)) {
                    cur.palindromeWordIds.add(index)
                }
                // 해당 문자의 자식 노드가 존재하지 않으면 신규 트라이 노드 생성
                // 'a'가 인덱스 0, 'z'는 인덱스 25가 된다.
                if (cur.children[c.toInt() - 'a'.toInt()] == null) {
                    cur.children[c.toInt() - 'a'.toInt()] = TrieNode()
                }
                // 자식 노드를 현재 노드로 교체
                cur = cur.children[c.toInt() - 'a'.toInt()]!!
            }
            // 단어가 완성된 후 단어의 인덱스 저장(그림에서 w로 표시)
            cur.wordId = index
        }

        // 팰린드롬 여부 판별
        fun search(index: Int, word: String): List<List<Int>> {
            // 루트부터 시작
            var cur: TrieNode = root
            // 결과 변수
            val result: MutableList<List<Int>> = mutableListOf()

            // 단어의 문자를 차례대로 반복하며 처리
            for (j in word.indices) {
                // (3) 탐색 중에 단어 ID가 있고(그림에서 w), 나머지 문자가 팰린드롬인 경우
                if (cur.wordId >= 0 && isPalindrome(word, j, word.length - 1)) {
                    result.add(listOf(index, cur.wordId))
                }
                // 자식 노드가 없으면 더 이상 팰린드롬이 아니므로 지금까지 결과를 리턴하면서 중단
                if (cur.children[word[j].toInt() - 'a'.toInt()] == null) return result
                // 자식 노드를 현재 노드로 교체
                cur = cur.children[word[j].toInt() - 'a'.toInt()]!!
            }
            // (1) 끝까지 탐색했을 때 단어 ID가 있는 경우(그림에서 w)
            if (cur.wordId >= 0 && cur.wordId != index) {
                result.add(listOf(index, cur.wordId))
            }
            // (2) 끝까지 탐색했을 때 팰린드롬 단어 ID가 있는 경우(그림에서 p)
            for (palindromeWordId in cur.palindromeWordIds) {
                result.add(listOf(index, palindromeWordId))
            }
            // 결과 리턴
            return result
        }
    }

    fun palindromePairs(words: Array<String>): List<List<Int>> {
        // 트라이 처리 클래스
        val t = Trie()
        // 결과 리스트 변수
        val results: MutableList<List<Int>> = mutableListOf()
        // 단어 목록을 하나씩 트라이에 추가
        for (i in words.indices) {
            t.insert(i, words[i])
        }
        // 단어 목록에서 하나씩 팰린드롬 여부를 판별하고 결과에 누적
        for (i in words.indices) {
            results.addAll(t.search(i, words[i]))
        }
        // 최종 결과 리턴
        return results
    }
}