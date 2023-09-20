package ch23;

import java.util.ArrayList;
import java.util.List;

public class ZeroOneKnapsackExample {
    static class Cargo {
        // 가치($)
        int price;
        // 무게(kg)
        int weight;

        public Cargo(int price, int weight) {
            this.price = price;
            this.weight = weight;
        }
    }

    public static int zeroOneKnapsack(List<Cargo> cargos) {
        // 용량
        int capacity = 15;
        // 짐 개수 x 배낭 용량, 2차원 배열 선언
        int[][] pack = new int[cargos.size() + 1][capacity + 1];

        for (int i = 0; i <= cargos.size(); i++) {
            // 배낭 용량을 점점 늘려가며 순회
            for (int c = 0; c <= capacity; c++) {
                if (i == 0 || c == 0) {
                    pack[i][c] = 0;
                } else if (cargos.get(i - 1).weight <= c) {
                    // 현재 짐 무게가 배낭 용량 이내인 경우 최대 가격 계산
                    pack[i][c] = Math.max(
                            // 현재 짐 가격 + 이전 짐의 현재 짐 무게를 뺀 용량의 가격
                            cargos.get(i - 1).price + pack[i - 1][c - cargos.get(i - 1).weight],
                            pack[i - 1][c]
                    );
                } else {
                    // 용량을 넘어선 경우 이전 짐의 가격을 그대로 이관
                    pack[i][c] = pack[i - 1][c];
                }
            }
        }

        return pack[cargos.size()][capacity];
    }

    public static void main(String[] args) {
        List<Cargo> cargos = new ArrayList<>();
        cargos.add(new Cargo(4, 12));
        cargos.add(new Cargo(2, 1));
        cargos.add(new Cargo(10, 4));
        cargos.add(new Cargo(1, 1));
        cargos.add(new Cargo(2, 2));

        int result = zeroOneKnapsack(cargos); // 15
        System.out.println(result);
    }
}
