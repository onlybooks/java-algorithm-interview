package ch16

class P62_2 {
    // 트라이의 노드
    class TrieNode {
        // 단어 완성 여부
        var word: Boolean = false

        // 트라이의 자식 노드들, 문제 제약 조건에 따라 소문자 알파벳으로 구성되므로
        // 자식 노드는 알파벳의 개수인 최대 26개까지 가능
        val children: Array<TrieNode?> = arrayOfNulls(26)
    }

    class Trie {
        // 루트로 빈 트라이 노드 생성
        var root: TrieNode = TrieNode()

        // 단어 삽입
        fun insert(word: String) {
            // 루트부터 시작
            var cur: TrieNode = root
            // 단어의 문자를 차례대로 반복하며 자식 노드 구성
            for (c in word) {
                // 해당 문자의 자식 노드가 존재하지 않으면 신규 트라이 노드 생성
                // 'a'가 인덱스 0, 'z'는 인덱스 25가 된다.
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = TrieNode()
                }
                // 자식 노드를 현재 노드로 교체
                cur = cur.children[c - 'a']!!
            }
            // 단어가 완성된 후이므로 현재 노드는 단어 완성 여부에 true 설정
            cur.word = true
        }

        // 단어 존재 여부 판별
        fun search(word: String): Boolean {
            // 루트부터 시작
            var cur: TrieNode = root
            // 단어의 문자를 차례대로 반복하며 자식 노드 구성
            for (c in word) {
                // 자식 노드가 존재하지 않으면 false 리턴
                if (cur.children[c - 'a'] == null)
                    return false
                // 자식 노드를 현재 노드로 교체
                cur = cur.children[c - 'a']!!
            }
            // 탐색이 종료된 후 단어 완성 여부를 리턴
            // 완성된 단어가 아니라면 문자는 모두 매칭이 되어도 단어 완성 여부는 false일 수 있음
            return cur.word
        }

        // 문자열로 시작 단어 존재 여부 판별
        fun startsWith(prefix: String): Boolean {
            // 루트부터 시작
            var cur: TrieNode = root
            // 단어의 문자를 차례대로 반복하며 자식 노드 구성
            for (c in prefix) {
                // 자식 노드가 존재하지 않으면 false 리턴
                if (cur.children[c - 'a'] == null)
                    return false
                // 자식 노드를 현재 노드로 교체
                cur = cur.children[c - 'a']!!
            }
            // 탐색이 종료되면 항상 true 리턴, 시작 여부만 판별하면 되므로 단어 완성 여부가 false여도 관계없음
            return true
        }
    }
}