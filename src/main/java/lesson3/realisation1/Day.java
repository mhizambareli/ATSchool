package lesson3.realisation1;

/**
 * Создать класс Day c полем String dayOfWeek и поле с номером относительно начала месяца (не статические).
 */
public class Day {
    String dayOfWeek; //Обозначение дня недели
    int numOfDay; //Номер дня относительно начала месяца

    Day(int numOfDay, String dayOfWeek) {
        this.numOfDay = numOfDay;
        this.dayOfWeek = dayOfWeek;
    }

    // Переопределяем метод toString() для быстрого вывода информации по объектам класса Day
    @Override
    public String toString() {
        return dayOfWeek + " - " + numOfDay + " число\n";
    }
}
