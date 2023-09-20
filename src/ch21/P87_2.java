package ch21;

import java.util.Arrays;

public class P87_2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 방문 가능한 입력값인지 필터링
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum())
            return -1;

        int start = 0, fuel = 0;
        // 전체 주유소를 순회하면서 성립되지 않는 위치를 찾는다.
        for (int i = 0; i < gas.length; i++) {
            // 남은 기름으로 출발점이 안 되는 주유소가 있다면 이미 지나친 지점도 전부 출발점이 될 수 없으므로
            // 출발점을 다음 지점으로 밀어낸다.
            if (fuel + gas[i] - cost[i] < 0) {
                start = i + 1;
                fuel = 0;
            } else {
                // 남은 기름을 계속 누적한다.
                fuel += gas[i] - cost[i];
            }
        }
        return start;
    }
}
