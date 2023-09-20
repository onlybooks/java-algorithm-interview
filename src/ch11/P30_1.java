package ch11;

class P30_1 {
    // 노드 클래스
    static class Node {
        int key, val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    final Node[] nodes = new Node[1000000];

    // 삽입
    public void put(int key, int value) {
        // 해싱 결과를 인덱스로 지정
        int index = key % nodes.length;
        // 해당 인덱스에 노드가 없다면 신규 생성 후 종료
        if (nodes[index] == null) {
            nodes[index] = new Node(key, value);
            return;
        }
        // 인덱스에 노드가 존재한다면 연결 리스트로 처리
        Node node = nodes[index];
        while (node != null) {
            // 동일한 키가 있다면 값을 업데이트하고 종료
            if (node.key == key) {
                node.val = value;
                return;
            }
            // 다음 노드가 없다면 종료
            if (node.next == null)
                break;
            // 다음 노드로 진행
            node = node.next;
        }
        // 마지막 노드 다음으로 연결
        node.next = new Node(key, value);
    }

    // 조회
    public int get(int key) {
        // 해싱 결과를 인덱스로 지정
        int index = key % nodes.length;
        // 인덱스에 노드가 존재하지 않으면 -1
        if (nodes[index] == null)
            return -1;
        // 인덱스에 노드가 존재한다면 일치하는 키 탐색
        Node node = nodes[index];
        while (node != null) {
            // 동일한 키가 있다면 값을 리턴
            if (node.key == key) {
                return node.val;
            }
            // 다음 노드로 진행
            node = node.next;
        }
        // 인덱스를 모두 순회해도 일치하는 키가 없다면 -1
        return -1;
    }

    // 삭제
    public void remove(int key) {
        // 해싱 결과를 인덱스로 지정
        int index = key % nodes.length;
        // 해당 인덱스에 노드가 없다면 종료
        if (nodes[index] == null)
            return;
        // 첫 번째 노드일 때의 삭제 처리
        Node node = nodes[index];
        // 일치하는 키가 있다면
        if (node.key == key) {
            // 다음 노드가 없으면 해당 인덱스는 null 처리
            if (node.next == null)
                nodes[index] = null;
            // 다음 노드가 있다면 다음 노드를 해당 인덱스로 지정
            else
                nodes[index] = node.next;
        }
        // 연결 리스트 노드일 때의 삭제 처리
        Node prev = node;
        while (node != null) {
            // 일치하는 키가 있다면
            if (node.key == key) {
                // 이전 노드의 다음에 현재 노드의 다음을 연결하고 리턴
                prev.next = node.next;
                return;
            }
            // 노드 한 칸씩 이동
            prev = node;
            node = node.next;
        }
    }
}
