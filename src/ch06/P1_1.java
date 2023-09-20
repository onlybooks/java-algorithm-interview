package ch06;

class P1_1 {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        // 서로 중앙으로 이동해 나가다 겹치는 지점에 도달하면 종료
        while (start < end) {
            // 영숫자인지 판별하고 유효하지 않으면 한 칸씩 이동
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else { // 유효한 문자라면 앞 글자와 뒷 글자를 모두 소문자로 변경해 비교
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    // 하나라도 일치하지 않는다면 팰린드롬이 아니므로 false 리턴
                    return false;
                }
                // 앞쪽 문자는 한 칸 뒤로, 뒤쪽 문자는 한 칸 앞으로 이동
                start++;
                end--;
            }
        }
        // 무사히 종료될 경우 팰린드롬이므로 true 리턴
        return true;
    }
}
