package Lesson3.realisation2;

/**
 * Создать класс Day c полем String dayOfWeek и поле с номером относительно начала месяца (не статические).
 */
public class Day {
    DaysOfWeek dayOfWeek; //Обозначение дня недели.
    int numOfDay; //Номер дня относительно начала месяца

    Day(int numOfDay, DaysOfWeek dayOfWeek) {
        this.numOfDay = numOfDay;
        this.dayOfWeek = dayOfWeek;
    }

    // Переопределяем метод toString() для быстрого вывода информации по объектам класса Day
    @Override
    public String toString() {
        return dayOfWeek.getDay() + " - " + numOfDay + " число\n";
    }
}
