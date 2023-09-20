package ch15;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeapExample {
    static class BinaryHeap {
        // 힙의 엘리먼트를 담아둘 리스트 변수
        public List<Integer> elems;

        public BinaryHeap() {
            // 클래스 생성시 빈 리스트를 선언하고, 첫 번째 값은 널을 삽입하여 사용하지 않음
            elems = new ArrayList<>();
            elems.add(null);
        }

        // 두 엘리먼트의 값을 교환해주는 메소드
        public void swap(int i, int j) {
            int temp = elems.get(i);
            elems.set(i, elems.get(j));
            elems.set(j, temp);
        }

        public void percolateUp() {
            // 마지막 엘리먼트 위치, 방금 삽입한 값이 위치한 곳이다.
            int idx = elems.size() - 1;
            // 부모 노드의 인덱스
            int parentIdx = idx / 2;
            // 부모 노드가 존재한다면 계속 반복
            while (parentIdx > 0) {
                // 부모 노드가 더 크면 값 스왑
                if (elems.get(idx) < elems.get(parentIdx)) {
                    // 현재 엘리먼트의 값과 부모 노드의 값 스왑
                    swap(idx, parentIdx);
                }
                // 현재 엘리먼트 값을 부모 노드로 지정
                idx = parentIdx;
                // 현재 엘리먼트의 부모 노드 지정
                parentIdx = idx / 2;
            }
        }

        public void insert(int k) {
            // 신규 엘리먼트 추가
            elems.add(k);
            // 업힙 연산 수행
            percolateUp();
        }

        public void minHeapify(int i) {
            // 왼쪽 자식 노드 인덱스
            int left = i * 2;
            // 오른쪽 자식 노드 인덱스
            int right = i * 2 + 1;
            // 현재 노드의 값을 가장 작은 값으로 가정
            int smallest = i;

            // 왼쪽 자식 노드가 존재하고 현재 노드의 값보다 더 작다면 가장 작은 값은 왼쪽 자식 노드로 선언
            if (left <= elems.size() - 1 && elems.get(left) < elems.get(smallest))
                smallest = left;
            // 오른쪽 자식 노드가 존재하고 현재 노드의 값보다 더 작다면 가장 작은 값은 오른쪽 자식 노드로 선언
            if (right <= elems.size() - 1 && elems.get(right) < elems.get(smallest))
                smallest = right;
            // 가장 작은 값이 현재 노드가 아니라면 값 스왑 진행
            if (smallest != i) {
                // 가장 작은 노드와 현재 노드의 값 스왑
                swap(smallest, i);
                // 스왑 이후 계속 진행
                minHeapify(smallest);
            }
        }

        public int extract() {
            // 루트 값 추출, 최소 힙이므로 가장 작은 값
            int extracted = elems.get(1);

            // 루트에 마지막 엘리먼트 삽입
            elems.set(1, elems.get(elems.size() - 1));
            // 마지막 엘리먼트는 제거
            elems.remove(elems.size() - 1);
            // 루트에 대해 다운힙 연산 수행
            minHeapify(1);

            // 추출한 기존 루트값 리턴
            return extracted;
        }
    }

    public static void main(String[] args) {
        BinaryHeap b = new BinaryHeap();

        b.insert(5);
        b.insert(27);
        b.insert(9);
        b.insert(14);
        b.insert(11);

        for (int i = 0; i < 5; i++) {
            System.out.println(b.extract());
        }
    }
}
