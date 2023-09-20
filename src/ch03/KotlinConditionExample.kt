package ch03

fun getTypeOfDayWithSwitchStatement(dayOfWeek: Int): String {
    val typeOfDay: String = when (dayOfWeek) {
        1 -> "한 주의 시작"
        2, 3, 4 -> "주중"
        5 -> "한 주의 끝"
        6, 7 -> "주말"
        else -> throw IllegalArgumentException("잘못된 날: $dayOfWeek")
    }
    return typeOfDay
}