package ch17;

import java.util.Arrays;

public class P68_1 {
    public String sort(String s) {
        // 문자열을 문자 배열로 변환
        char[] chars = s.toCharArray();
        // 문자 배열을 정렬
        Arrays.sort(chars);
        // 문자 배열을 문자열로 만들어 리턴
        return new String(chars);
    }

    public boolean isAnagram(String s, String t) {
        // s를 정렬한 결과와 t를 정렬한 결과가 일치하는지 비교
        return sort(s).equals(sort(t));
    }
}
