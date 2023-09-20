package ch24

class P99_2 {
    var maxScore = 0
    var info: IntArray = IntArray(11) // 불필요한 파라미터 전달을 없애기 위해 멤버 변수 선언
    var answer = IntArray(11)

    // 점수 차이 계산
    fun calcScore(lion: IntArray): Int {
        var diff = 0
        for (i in 0..10) {
            if (lion[i] == 0 && info[i] == 0)
                continue
            diff = if (lion[i] > info[i])
                diff + (10 - i)
            else
                diff - (10 - i)
        }
        return diff
    }

    fun dfs(index: Int, lion: IntArray, arrow: Int) {
        // 최종 인덱스 도달 시 결과 처리
        if (index == 11) {
            lion[10] = arrow // 화살이 남아 있다면 모두 10번 인덱스(점수 0)에 부여
            // 점수 차이 계산
            val score = calcScore(lion)
            // 기존 최고 점수 차이를 능가하는 경우 교체
            if (score > maxScore) {
                maxScore = score
                answer = lion.copyOf(lion.size)
            } else if (score == maxScore) { // 점수 차이가 같은 경우
                for (i in 10 downTo 0) {
                    if (lion[i] == answer[i])
                        continue
                    // 뒤에서부터 더 많이 맞힌 경우 정답 교체
                    if (lion[i] > answer[i])
                        answer = lion.copyOf(lion.size)
                    break
                }
            }
            return
        }

        // 어피치보다 화살+1 또는 0 둘 중 하나로 DFS 진행
        if (info[index] < arrow) {
            lion[index] = info[index] + 1
            dfs(index + 1, lion, arrow - lion[index])
            lion[index] = 0
        }
        dfs(index + 1, lion, arrow)
    }

    fun solution(n: Int, info: IntArray): IntArray {
        this.info = info // 각종 메소드에서 활용하기 위해 멤버 변수에 할당
        dfs(0, IntArray(11), n)

        // 정답이 없으면 -1 리턴
        return if (maxScore == 0)
            intArrayOf(-1)
        else
            answer
    }
}