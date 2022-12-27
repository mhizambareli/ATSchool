package Lesson3.realisation2;

/**
 * Enum DaysOfWeek - перечисление дней недели
 */
public enum DaysOfWeek {
    MONDAY("Понедельник"),
    TUESDAY("Вторник"),
    WEDNESDAY("Среда"),
    THURSDAY("Четверг"),
    FRIDAY("Пятница"),
    SATURDAY("Суббота"),
    SUNDAY("Воскресенье");

    private String day;

    DaysOfWeek(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }
}
