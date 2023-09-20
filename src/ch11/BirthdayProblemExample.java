package ch11;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class BirthdayProblemExample {
    public static void main(String[] args) {
        // 같은 날 횟수를 기록하는 변수
        int sameBirthdays = 0;
        // 10만 번 실험 진행
        for (int i = 0; i < 100000; i++) {
            int[] birthdays = new int[23];
            // 23명이 모이는 경우
            for (int j = 0; j < 23; j++) {
                // 365일 중 랜덤하게 지정
                int birthday = ThreadLocalRandom.current().nextInt(1, 365 + 1);
                // 만약 같은 날이 존재한다면 일치 여부 +1 이후 다음 실험 진행
                if (IntStream.of(birthdays).anyMatch(x -> x == birthday)) {
                    sameBirthdays++;
                    break;
                }
                // 일치하지 않은 경우 저장하고 다음 사람으로
                birthdays[j] = birthday;
            }
        }
        System.out.print("10만 번 실험 중 생일이 같은 실험의 확률: ");
        System.out.print((double) sameBirthdays / 100000 * 100);
        System.out.println("%");
    }
}
