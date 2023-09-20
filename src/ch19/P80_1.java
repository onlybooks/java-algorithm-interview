package ch19;

public class P80_1 {
    public int hammingWeight(int n) {
        // XOR 연산자를 사용해 해밍 가중치를 구한다.
        int xor = n ^ 0;
        // 정수형을 이진수로 표현했을 때 1비트의 개수를 구한다.
        return Integer.bitCount(n);
    }
}
