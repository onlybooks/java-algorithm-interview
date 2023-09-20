package ch20;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P83_1 {
    public int characterReplacement(String s, int k) {
        int left = 0;
        // 문자 개수를 저장하는 맵
        Map<Character, Integer> counts = new HashMap<>();
        // 오른쪽 포인터가 끝까지 이동하면서 순회
        for (int right = 1; right <= s.length(); right++) {
            // 윈도우 맨 오른쪽 문자의 카운트 증가
            counts.put(s.charAt(right - 1), counts.getOrDefault(s.charAt(right - 1), 0) + 1);
            // 가장 흔하게 등장하는 문자의 개수 추출
            int maxCharCount = Collections.max(counts.values());

            // k 초과 시 왼쪽 포인터 이동, 조건에 맞지 않으면 윈도우 크기는 더 이상 커지지 않고 끝까지 유지된다.
            if (right - left - maxCharCount > k) {
                // 윈도우 맨 왼쪽 문자의 카운트 감소
                counts.put(s.charAt(left), counts.getOrDefault(s.charAt(left), 0) - 1);
                // 왼쪽 포인터 이동
                left++;
            }
        }
        // 오른쪽 포인터는 끝까지 이동했으므로 문자열 길이와 동일,
        // 여기에 왼쪽 포인터 위치를 뺀 값을 정답으로 리턴
        return s.length() - left;
    }
}
