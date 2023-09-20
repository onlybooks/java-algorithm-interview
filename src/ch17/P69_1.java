package ch17;

public class P69_1 {
    public void sortColors(int[] nums) {
        // red와 blue는 양쪽 끝 포인터이며, white는 중앙에서 움직이는 포인터다.
        int red = 0;
        int white = 0;
        int blue = nums.length;

        // 두 값이 역전될 때까지 반복
        while (white < blue) {
            // white 포인터가 중앙값보다 작다면
            if (nums[white] < 1) {
                // red와 white 스왑
                int temp = nums[red];
                nums[red] = nums[white];
                nums[white] = temp;
                // red와 white 포인터는 한 칸씩 우측으로 이동
                red++;
                white++;
            } else if (nums[white] > 1) { // white 포인터가 중앙값보다 크다면
                // blue 포인터 좌측으로 이동
                blue--;
                // white와 blue 스왑
                int temp = nums[white];
                nums[white] = nums[blue];
                nums[blue] = temp;
            } else {
                // 값이 같은 경우이므로, 스왑 없이 white 포인터만 우측으로 이동
                white++;
            }
        }
    }
}
