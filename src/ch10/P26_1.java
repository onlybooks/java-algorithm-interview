package ch10;

public class P26_1 {
    // 이중 연결 리스트로 사용할 클래스 선언
    static class DoublyLinkedList {
        // 왼쪽으로 연결할 이중 연결 리스트
        DoublyLinkedList left;
        // 오른쪽으로 연결할 이중 연결 리스트
        DoublyLinkedList right;
        int val;

        public DoublyLinkedList(int val) {
            this.val = val;
        }
    }

    int len;                // 현재 큐의 크기
    int k;                  // 전체 큐의 크기
    DoublyLinkedList head;  // 이중 연결 리스트 head 노드
    DoublyLinkedList tail;  // 이중 연결 리스트 tail 노드

    public P26_1(int k) {
        // 이중 연결 리스트 2개 생성
        head = new DoublyLinkedList(0);
        tail = new DoublyLinkedList(0);
        // 서로 연결
        head.right = tail;
        tail.left = head;
        // 전체 큐의 크기 지정
        this.k = k;
        // 현재 큐의 크기 지정
        this.len = 0;
    }

    public boolean insertFront(int value) {
        // 꽉 차 있으면 진행하지 않음
        if (isFull())
            return false;
        DoublyLinkedList node = new DoublyLinkedList(value);
        // 신규 노드는 head 바로 오른쪽에 삽입
        node.right = head.right;
        node.left = head;
        head.right.left = node;
        head.right = node;
        len++;
        return true;
    }

    public boolean insertLast(int value) {
        // 꽉 차 있으면 진행하지 않음
        if (isFull())
            return false;
        DoublyLinkedList node = new DoublyLinkedList(value);
        // 신규 노드는 tail 바로 왼쪽에 삽입
        node.left = tail.left;
        node.right = tail;
        tail.left.right = node;
        tail.left = node;
        len++;
        return true;
    }

    public boolean deleteFront() {
        // 텅 비어 있다면 진행하지 않음
        if (isEmpty())
            return false;
        // head 바로 오른쪽 노드를 연결에서 끊음
        head.right.right.left = head;
        head.right = head.right.right;
        len--;
        return true;
    }

    public boolean deleteLast() {
        // 텅 비어 있다면 진행하지 않음
        if (isEmpty())
            return false;
        // tail 바로 왼쪽 노드를 연결에서 끊음
        tail.left.left.right = tail;
        tail.left = tail.left.left;
        len--;
        return true;
    }

    public int getFront() {
        // 맨 앞(head 오른쪽)의 값을 가져온다.
        return (isEmpty()) ? -1 : head.right.val;
    }

    public int getRear() {
        // 맨 뒤(tail 왼쪽)의 값을 가져온다.
        return (isEmpty()) ? -1 : tail.left.val;
    }

    public boolean isEmpty() {
        // 현재 큐의 크기가 0이면 비어 있음
        return len == 0;
    }

    public boolean isFull() {
        // 현재 큐의 크기가 처음 선언한 큐의 크기와 일치하면 꽉 차 있음
        return len == k;
    }
}
