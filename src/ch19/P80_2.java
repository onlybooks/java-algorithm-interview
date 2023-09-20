package ch19;

public class P80_2 {
    public int hammingWeight(int n) {
        int count = 0;
        // 0이 될 때까지 전체 반복
        while (n != 0) {
            // 1을 뺀 값과 AND 연산
            n &= n - 1;
            // 1비트씩 빠지게 되므로 카운트는 1씩 증가
            count++;
        }
        return count;
    }
}
