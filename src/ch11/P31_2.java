package ch11;

import java.util.HashSet;
import java.util.Set;

class P31_2 {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<Character> freqs = new HashSet<>();

        // 보석(J) 종류 저장
        for (char j : J.toCharArray())
            freqs.add(j);
        // 돌(S)이 보석(J)인 경우 +1
        for (char s : S.toCharArray())
            if (freqs.contains(s)) count++;
        return count;
    }
}
