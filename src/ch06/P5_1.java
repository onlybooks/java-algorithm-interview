package ch06;

import java.util.*;

public class P5_1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> results = new HashMap<>();

        for (String s : strs) {
            // 문자열을 문자 배열로 변환
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            // 문자 배열을 키로 하기 위해 다시 문자열로 변환
            String key = String.valueOf(chars);

            // 만약 기존에 없던 키라면 빈 리스트를 삽입
            if (!results.containsKey(key))
                results.put(key, new ArrayList<>());
            // 키에 해당하는 리스트에 추가
            results.get(key).add(s);
        }
        return new ArrayList<>(results.values());
    }
}
