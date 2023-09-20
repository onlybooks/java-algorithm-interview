package ch11;

import java.util.HashMap;
import java.util.Map;

// 해시 > 완주하지 못한 선수
public class P34_1 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> m = new HashMap<>();
        // 참여 선수 이름, 동명이인인 경우 +1 해시맵 삽입
        for (String p : participant)
            m.put(p, m.getOrDefault(p, 0) + 1);

        // 완주 선수 이름 제거
        for (String c : completion) {
            int left = m.get(c);
            if (left == 1) // 하나만 있는 경우 키 자체를 삭제
                m.remove(c);
            else
                m.put(c, left - 1);
        }
        // 남아 있는 유일한 키(이름) 리턴
        return m.entrySet().iterator().next().getKey();
    }
}
