package ch09;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P20_1 {
    public boolean isValid(String s) {
        // 유효성 검증을 위한 스택 선언
        Deque<Character> stack = new ArrayDeque<>();
        // 유효성 검증을 위한 매핑 테이블
        Map<Character, Character> table = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        // 문자열을 문자 단위로 반복
        for (int i = 0; i < s.length(); i++) {
            // 닫힘 괄호가 아닌 경우 스택에 푸시
            if (!table.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            // 중간에 스택이 비거나 팝 결과가 열림 괄호가 아닌 경우 유효하지 않음
            } else if (stack.isEmpty() || table.get(s.charAt(i)) != stack.pop()) {
                return false;
            }
        }
        // 유효한 입력이 되려면 반복 완료 후 스택이 비어야 한다.
        return stack.size() == 0;
    }
}
