package ch24;

import java.util.ArrayDeque;
import java.util.Deque;

public class P97_1 {
    // 소수 여부 판별 메소드
    public boolean isPrime(int num) {
        // 1은 소수가 아니므로 예외 처리
        if (num == 1)
            return false;

        // 3부터 차례대로 나눠지는지 확인
        for (int i = 3; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public int solution(int n, int k) {
        // 입력의 역순으로 추출해야 변환된 수가 완성되므로 스택 선언
        Deque<Integer> stack = new ArrayDeque<>();
        int remainder;
        // k진수로 자릿수 단위로 변환하면서 스택 삽입
        while (n != 0) {
            remainder = n % k;
            n /= k;
            stack.push(remainder);
        }

        // 스택에서 추출하여 변환 완성
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());

        // 0을 기준으로 구분하여 각각 소수 여부 처리
        int answer = 0;
        for (String s : sb.toString().split("0")) {
            // 00인 경우 빈 값이 될 수 있으므로 예외 처리
            if (s.equals(""))
                continue;
            // 소수인 경우 정답 +1
            if (isPrime(Integer.parseInt(s)))
                answer++;
        }
        return answer;
    }
}
