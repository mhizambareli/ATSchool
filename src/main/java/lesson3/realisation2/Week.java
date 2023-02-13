package lesson3.realisation2;

import static lesson3.realisation2.DaysOfWeek.*;

/**
 * Создать класс Week содержащий 7 полей Day и поле номера недели относительно начала года (не статическое).
 */
public class Week {
    public int numOfWeek; // Номер недели относительно начала года
    Day day1;
    Day day2;
    Day day3;
    Day day4;
    Day day5;
    Day day6;
    Day day7;

    /**
     * Конструктор класса Week
     *
     * @param numOfWeek - номер недели относительно начала года
     * @param day1      - номер первого дня в неделе. Номер относительно начала месяца
     * @param day2      - номер второго дня в неделе. Номер относительно начала месяца
     * и т.д. вплоть до day7
     */
    Week(int numOfWeek, int day1, int day2, int day3, int day4, int day5, int day6, int day7) {
        this.numOfWeek = numOfWeek;
        this.day1 = new Day(day1, MONDAY);
        this.day2 = new Day(day2, TUESDAY);
        this.day3 = new Day(day3, WEDNESDAY);
        this.day4 = new Day(day4, THURSDAY);
        this.day5 = new Day(day5, FRIDAY);
        this.day6 = new Day(day6, SATURDAY);
        this.day7 = new Day(day7, SUNDAY);
    }


    //Переопределяем метод toString() для быстрого вывода информации по классу Week
    @Override
    public String toString() {
        return numOfWeek + " неделя 2022 года:\n"
                + day1.toString()
                + day2.toString()
                + day3.toString()
                + day4.toString()
                + day5.toString()
                + day6.toString()
                + day7.toString();
    }
}
