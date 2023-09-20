package ch21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsackExample {
    static class Cargo {
        // 가치($)
        int price;
        // 무게(kg)
        int weight;
        // 단가($/kg)
        float unitPrice;

        public Cargo(int price, int weight) {
            this.price = price;
            this.weight = weight;
        }

        public void setUnitPrice(float unitPrice) {
            this.unitPrice = unitPrice;
        }
    }

    public static float fractionalKnapsack(List<Cargo> cargo) {
        // 용량
        int capacity = 15;
        // 담을 수 있는 최댓값
        float totalValue = 0;

        // 단가를 계산하여 업데이트
        for (Cargo c : cargo) {
            c.setUnitPrice((float) c.price / c.weight);
        }
        // 단가 역순으로 정렬
        cargo.sort(Comparator.comparingDouble(a -> a.unitPrice * -1));

        // 배낭에 단가 역순으로 담긴 짐의 최댓값 계산
        for (Cargo c : cargo) {
            // 짐을 쪼개지 않아도 되는 경우 전체 가격 증가
            if (capacity - c.weight >= 0) {
                capacity -= c.weight;
                totalValue += c.price;
            } else { // 짐을 쪼개야 하는 경우 쪼갠만큼 가격 증가
                float fraction = (float) capacity / c.weight;
                totalValue += c.price * fraction;
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        List<Cargo> cargo = new ArrayList<>();
        cargo.add(new Cargo(4, 12));
        cargo.add(new Cargo(2, 1));
        cargo.add(new Cargo(10, 4));
        cargo.add(new Cargo(1, 1));
        cargo.add(new Cargo(2, 2));

        float result = fractionalKnapsack(cargo); // 17.333334
        System.out.println(result);
    }
}
