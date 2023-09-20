package ch10

class KotlinNestedClassExample {
    var outerVal: Int = 0

    // 중첩 클래스
    class NestedClass {
        init {
            // outerVal = 1 // 에러
            var nestedVal: Int = 2
        }
    }

    // 내부 클래스
    inner class InnerClass {
        init {
            outerVal = 3 // 정상
            var innerVal = 4
        }
    }
}