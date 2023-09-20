package ch21;

public class P87_1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 모든 주유소를 출발점으로 대입해보는 브루트 포스 풀이
        for (int start = 0; start < gas.length; start++) {
            // 남은 기름
            int fuel = 0;
            boolean canTravel = true;
            for (int i = start; i < gas.length + start; i++) {
                // 전체 주유소 개수를 넘어서면 모듈로 연산으로 출발점 이전 인덱스 계산
                int index = i % gas.length;

                // 한 번이라도 기름이 0 밑으로 떨어지면 더 이상 운행할 수 없으므로 중단
                if (fuel + gas[index] - cost[index] < 0) {
                    canTravel = false;
                    break;
                } else {
                    fuel += gas[index] - cost[index];
                }
            }
            // 모든 주유소를 다 방문했음에도 true라면 정답이므로 출발 주유소 리턴
            if (canTravel)
                return start;
        }
        return -1;
    }
}
