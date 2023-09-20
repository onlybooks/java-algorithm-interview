package ch10;

public class JavaNestedClassExample {
    int outerVal;

    // 내부 클래스(비정적 중첩 클래스)
    class InnerClass {
        int innerVal;

        public InnerClass() {
            outerVal = 1; // 정상
            innerVal = 2; // 정상
        }
    }

    // 정적 중첩 클래스
    static class StaticNestedClass {
        int nestedVal;

        public StaticNestedClass() {
            // outerVal = 3;    // 에러
            nestedVal = 4;      // 정상
        }
    }
}
