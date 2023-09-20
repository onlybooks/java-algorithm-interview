package ch03;

public class JavaConditionExample {
    public String getTypeOfDayWithSwitchStatement(int dayOfWeek) {
        String typeOfDay;
        switch (dayOfWeek) {
            case 1:
                typeOfDay = "한 주의 시작";
                break;
            case 2:
            case 3:
            case 4:
                typeOfDay = "주중";
                break;
            case 5:
                typeOfDay = "한 주의 끝";
                break;
            case 6:
            case 7:
                typeOfDay = "주말";
                break;
            default:
                throw new IllegalArgumentException("잘못된 날: " + dayOfWeek);
        }
        return typeOfDay;
    }
}
