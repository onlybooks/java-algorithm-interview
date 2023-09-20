package ch10

class P26_2(k: Int) {
    // 이중 연결 리스트로 사용할 클래스 선언
    data class DoublyLinkedList(var `val`: Int) {
        // 왼쪽으로 연결할 이중 연결 리스트
        var left: DoublyLinkedList? = null

        // 오른쪽으로 연결할 이중 연결 리스트
        var right: DoublyLinkedList? = null
    }

    // 현재 큐의 크기
    var len = 0

    // 전체 큐의 크기
    var k = 0

    // 이중 연결 리스트 head 노드
    var head: DoublyLinkedList? = null

    // 이중 연결 리스트 tail 노드
    var tail: DoublyLinkedList? = null

    // 초기화 블록
    init {
        // 이중 연결 리스트 2개 생성
        head = DoublyLinkedList(0)
        tail = DoublyLinkedList(0)
        // 서로 연결
        head!!.right = tail
        tail!!.left = head
        // 전체 큐의 크기 지정
        this.k = k
        // 현재 큐의 크기 지정
        len = 0
    }

    fun insertFront(value: Int): Boolean {
        // 꽉 차 있으면 진행하지 않음
        if (isFull()) return false
        val node = DoublyLinkedList(value)
        // 신규 노드는 head 바로 오른쪽에 삽입
        node.right = head!!.right
        node.left = head
        head!!.right!!.left = node
        head!!.right = node
        len++
        return true
    }

    fun insertLast(value: Int): Boolean {
        // 꽉 차 있으면 진행하지 않음
        if (isFull()) return false
        val node = DoublyLinkedList(value)
        // 신규 노드는 tail 바로 왼쪽에 삽입
        node.left = tail!!.left
        node.right = tail
        tail!!.left!!.right = node
        tail!!.left = node
        len++
        return true
    }

    fun deleteFront(): Boolean {
        // 텅 비어 있다면 진행하지 않음
        if (isEmpty()) return false
        // head 바로 오른쪽 노드를 연결에서 끊음
        head!!.right!!.right!!.left = head
        head!!.right = head!!.right!!.right
        len--
        return true
    }

    fun deleteLast(): Boolean {
        // 텅 비어 있다면 진행하지 않음
        if (isEmpty()) return false
        // tail 바로 왼쪽 노드를 연결에서 끊음
        tail!!.left!!.left!!.right = tail
        tail!!.left = tail!!.left!!.left
        len--
        return true
    }

    fun getFront(): Int {
        // 맨 앞(head 오른쪽)의 값을 가져온다.
        return if (isEmpty()) -1 else head!!.right!!.`val`
    }

    fun getRear(): Int {
        // 맨 뒤(tail 왼쪽)의 값을 가져온다.
        return if (isEmpty()) -1 else tail!!.left!!.`val`
    }

    fun isEmpty(): Boolean {
        // 현재 큐의 크기가 0이면 비어 있음
        return len == 0
    }

    fun isFull(): Boolean {
        // 현재 큐의 크기가 처음 선언한 큐의 크기와 일치하면 꽉 차 있음
        return len == k
    }
}