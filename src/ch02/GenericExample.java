package ch02;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {
    public static void main(String[] args) {
        List listNames1 = new ArrayList();
        listNames1.add("카리나");
        listNames1.add("윈터");
        listNames1.add("지젤");
        listNames1.add("닝닝");
        String name0 = (String) listNames1.get(0);

        listNames1.add(34);
        // String name4 = (String) listNames1.get(4); // 에러 발생

        // ---

        List<String> listNames2 = new ArrayList<String>();
        listNames2.add("카리나");
        listNames2.add("윈터");
        listNames2.add("지젤");
        listNames2.add("닝닝");
        // listNames2.add(34); // 에러 발생

        for (String name : listNames2) {
            System.out.println(name);
        }
    }
}
