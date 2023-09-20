package ch19;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P78_1 {
    public int getSum(int a, int b) {
        // 정수형을 32비트 이진수 문자열로 변환
        String binA = String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0');
        String binB = String.format("%32s", Integer.toBinaryString(b)).replace(' ', '0');

        // 결과 리스트
        List<Character> result = new ArrayList<>();
        // 자리올림 수
        int carry = 0;
        // 합
        int sum;

        // 32비트 모든 자리를 뒤에서부터 계산
        for (int i = 0; i < 32; i++) {
            // 뒤에서부터 비트값을 정수형으로 추출
            int A = Character.getNumericValue(binA.charAt(31 - i));
            int B = Character.getNumericValue(binB.charAt(31 - i));

            // 전가산기 구현
            int Q1 = A & B;
            int Q2 = A ^ B;
            int Q3 = Q2 & carry;
            sum = carry ^ Q2;
            carry = Q1 | Q3;

            // int를 Character로 변환하여 리스트 앞쪽으로 추가
            result.add(0, Character.forDigit(sum, 2));
        }

        // 이진수 문자열을 정수형으로 변환하여 리턴
        return Integer.parseUnsignedInt(
                // 결과 리스트를 문자열로 변환
                result.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(""))
                , 2);
    }
}
