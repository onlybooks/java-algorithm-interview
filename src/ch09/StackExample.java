package ch09;


public class StackExample {
    static class MyNode {
        int item;
        // 노드의 다음 노드
        MyNode next;

        public MyNode(int item, MyNode next) {
            this.item = item;
            this.next = next;
        }
    }

    static class MyStack {
        MyNode last;

        // 스택 최초 생성시 마지막 노드는 없음
        public MyStack() {
            this.last = null;
        }

        public void push(int item) {
            // 입력값으로 신규 노드를 생성하며, 기존의 마지막 노드는 다음 노드가 된다.
            this.last = new MyNode(item, this.last);
        }

        public int pop() {
            // 마지막 노드의 값을 끄집어낸다.
            int item = this.last.item;
            // 마지막 노드를 한 칸 앞으로 이동한다.
            this.last = this.last.next;
            return item;
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        for (int i = 0; i < 5; i++) {
            System.out.println(stack.pop());
        }
    }
}
