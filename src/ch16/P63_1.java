package ch16;

import java.util.ArrayList;
import java.util.List;

public class P63_1 {
    public boolean isPalindrome(String s) {
        // 정규식으로 유효한 문자만 추출한 다음 모두 소문자로 변경
        String s_filtered = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        // 문자열을 뒤집은 다음 String으로 변경
        String s_reversed = new StringBuilder(s_filtered).reverse().toString();
        // 두 문자열이 동일한지 비교
        return s_filtered.equals(s_reversed);
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        // 결과 변수
        List<List<Integer>> results = new ArrayList<>();

        // 단어 목록 전체 순회
        for (int i = 0; i < words.length; i++) {
            // 단어 목록 전체 순회, 2번 반복하므로 시간 복잡도는 O(n^2)이다.
            for (int j = 0; j < words.length; j++) {
                // 동일한 인덱스인 경우 건너뛴다.
                if (i == j) continue;

                // 만약 두 단어의 조합이 팰린드롬인 경우 결과에 저장
                if (isPalindrome(words[i] + words[j])) {
                    // 인덱스 i와 j를 결과에 저장
                    List<Integer> result = new ArrayList<>();
                    result.add(i);
                    result.add(j);
                    // 결과를 결과 목록 변수에 저장
                    results.add(result);
                }
            }
        }
        // 최종 결과 리턴
        return results;
    }
}
