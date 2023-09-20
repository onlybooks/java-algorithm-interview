package ch09

class P25_2(k: Int) {
    // k 크기의 원형 큐로 사용할 배열 선언
    var q: IntArray = IntArray(k)
    var front = 0
    var rear = -1
    var len = 0

    fun enQueue(value: Int): Boolean {
        // 꽉 차 있지 않다면 삽입 진행
        return if (!isFull()) {
            // rear 포인터 한 칸 앞으로 이동, 최대 크기를 초과하면 나머지 위치로 이동
            this.rear = (this.rear + 1) % this.q.size
            // rear 위치에 값 삽입
            this.q[rear] = value
            // 현재 큐의 크기 계산
            this.len++
            true
        } else
            false
    }

    fun deQueue(): Boolean {
        // 텅 비어 있지 않다면 삭제 진행
        return if (!this.isEmpty()) {
            // front 포인터 한 칸 앞으로 이동, 최대 크기를 초과하면 나머지 위치로 이동
            this.front = (this.front + 1) % this.q.size
            // 현재 큐의 크기 계산
            this.len--
            true
        } else
            false
    }

    fun Front(): Int {
        // 맨 앞의 값을 가져온다.
        return if (this.isEmpty())
            -1
        else
            q[front]
    }

    fun Rear(): Int {
        // 맨 뒤의 값을 가져온다.
        return if (this.isEmpty())
            -1
        else
            q[this.rear]
    }

    fun isEmpty(): Boolean {
        // 현재 큐의 크기가 0이면 비어 있음
        return this.len == 0
    }

    fun isFull(): Boolean {
        // 현재 큐의 크기가 전체 큐의 크기와 일치하면 꽉 차 있음
        return this.len == this.q.size
    }
}