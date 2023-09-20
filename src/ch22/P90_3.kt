package ch22

class P90_3 {
    var memo: MutableMap<String, List<Int>> = mutableMapOf()

    fun diffWaysToCompute(expression: String): List<Int> {
        val result: MutableList<Int> = mutableListOf()
        // 이미 계산해둔 동일한 표현식이라면 기존 결과 재활용
        if (memo.containsKey(expression))
            return memo[expression]!!

        for (i in expression.indices) {
            val c = expression[i]
            // 연산자가 등장하면 좌, 우 분할하여 각각 계산 결과를 리턴받아 처리한다.
            if (c in "+-*") {
                // 연산자가 등장한 위치를 기준으로 좌, 우 분할
                val left = diffWaysToCompute(expression.substring(0, i))
                val right = diffWaysToCompute(expression.substring(i + 1))

                // 좌, 우 분할된 표현식의 연산 결과 리스트를 받아서 모두 순회하며 연산 처리
                for (l in left) {
                    for (r in right) {
                        when (c) {
                            '+' -> result.add(l + r)
                            '-' -> result.add(l - r)
                            '*' -> result.add(l * r)
                        }
                    }
                }
            }
        }
        // 연산 결과가 없다는 것은 연산자가 포함되어 있지 않다는 뜻이며, 정숫값만 있는 경우이므로 이 값만 담아서 리턴
        if (result.isEmpty())
            result.add(expression.toInt())
        // 계산 결과는 추후 재활용을 위해 저장
        memo[expression] = result
        return result
    }
}