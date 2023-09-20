package ch20;

public class P82_1 {
    public boolean contains(String sSubstr, String t) {
        // 문자열을 문자 단위로 편하게 처리하기 위해 StringBuilder로 변환
        StringBuilder sb = new StringBuilder(sSubstr);
        // t를 문자 단위로 반복
        for (char tElem : t.toCharArray()) {
            // t의 문자가 sb에 포함되어 있다면 삭제하면서 진행
            if (sb.indexOf(String.valueOf(tElem)) != -1)
                sb.deleteCharAt(sb.indexOf(String.valueOf(tElem)));
            else
                return false;
        }
        // 중간에 빠진 문자 없이 모든 문자가 삭제됐다면 true 리턴
        return true;
    }

    public String minWindow(String s, String t) {
        // 슬라이딩 윈도우의 크기는 t의 크기부터 시작해서 점점 증가
        for (int windowSize = t.length(); windowSize < s.length() + 1; windowSize++) {
            // 해당 슬라이딩 윈도우로 전체 순회
            for (int left = 0; left < s.length() - windowSize + 1; left++) {
                // 윈도우 크기만큼 부분 문자열 생성
                String sSubstr = s.substring(left, left + windowSize);

                // 부분 문자열이 t를 포함하면 정답으로 리턴
                if (contains(sSubstr, t))
                    return sSubstr;
            }
        }
        return "";
    }
}
