package ch24;

public class P97_4 {
    // 소수 여부 판별 메소드
    public boolean isPrime(long num) {
        // 1은 소수가 아니며, 2이상인데 2로 나눠지면 소수가 아니므로 미리 처리
        if (num == 1 || (num > 2 && num % 2 == 0))
            return false;

        // 3부터 차례대로 나눠지는지 확인
        for (int i = 3; i <= (int) Math.sqrt(num); i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public int solution(int n, int k) {
        // k 진수 문자열로 변환
        String str = Integer.toString(n, k);

        // 0을 기준으로 구분하여 각각 소수 여부 처리
        int answer = 0;
        for (String s : str.split("0")) {
            // 00인 경우 빈 값이 될 수 있으므로 예외 처리
            if (s.equals(""))
                continue;
            // 소수인 경우 정답 +1
            if (isPrime(Long.parseLong(s)))
                answer++;
        }
        return answer;
    }
}
