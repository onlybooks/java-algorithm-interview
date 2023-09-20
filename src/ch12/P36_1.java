package ch12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P36_1 {
    public void dfs(List<String> result, Map<Character, List<Character>> dic, String digits, int index, StringBuilder path) {
        // 끝까지 탐색했으면 결과를 저장하고 리턴
        if (path.length() == digits.length()) {
            result.add(String.valueOf(path));
            return;
        }

        // 현재 자리 숫자에 해당하는 모든 문자열 탐색
        for (Character c : dic.get(digits.charAt(index))) {
            // 현재 자리 +1, 지금까지 구성된 문자열 path 이용 재귀 DFS
            dfs(result, dic, digits, index + 1, new StringBuilder(path).append(c));
        }
    }

    public List<String> letterCombinations(String digits) {
        // 결과 저장 리스트 선언
        List<String> result = new ArrayList<>();
        // 예외 처리
        if (digits.length() == 0)
            return result;

        // 번호로 조합 가능한 문자 목록 구성
        Map<Character, List<Character>> dic = new HashMap<>();
        dic.put('0', List.of());
        dic.put('1', List.of());
        dic.put('2', List.of('a', 'b', 'c'));
        dic.put('3', List.of('d', 'e', 'f'));
        dic.put('4', List.of('g', 'h', 'i'));
        dic.put('5', List.of('j', 'k', 'l'));
        dic.put('6', List.of('m', 'n', 'o'));
        dic.put('7', List.of('p', 'q', 'r', 's'));
        dic.put('8', List.of('t', 'u', 'v'));
        dic.put('9', List.of('w', 'x', 'y', 'z'));

        // 현재 자리 0, 빈 문자열 이용 DFS 시작
        dfs(result, dic, digits, 0, new StringBuilder());
        return result;
    }
}
