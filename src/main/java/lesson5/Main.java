package lesson5;

import java.time.*;

import static java.util.Calendar.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        /**
         * 1) Создайте объект даты вашего рождения
         * и выведите на экран 5ю различными форматами вывода.
         * Повторите, используя каждый класс для работы с датой:
         * Date, LocalDate, LocalDateTime, ZonedDateTime, GregorianCalendar
         */

        long startTime = System.currentTimeMillis();//общее начало отсчёта для всего задания 1 и для класса Date
        Date myBirthday = new Date(100, 0, 7);
        System.out.println(myBirthday);
        long durationDate = System.currentTimeMillis() - startTime;// конец для класса Date

        long startTimeLD = System.currentTimeMillis(); //начало для класса LocalDate
        LocalDate myBirthday2 = LocalDate.of(2000, 1, 7);
        System.out.println(myBirthday2);
        long durationLD = System.currentTimeMillis() - startTimeLD; //конец для класса LocalDate

        long startTimeLDT = System.currentTimeMillis(); //начало для класса LocalDateTime
        LocalDateTime myBirthday3 = LocalDateTime.of(2000, 1, 7, 3, 50, 15);
        System.out.println(myBirthday3);
        long durationLDT = System.currentTimeMillis() - startTimeLDT;//конец для класса LocalDateTime

        long startTimeZDT = System.currentTimeMillis(); //начало для класса ZonedDateTime
        ZonedDateTime myBirthday4 = ZonedDateTime.of(2000, 1, 7, 3, 50, 15, 0, ZoneId.of("Europe/Moscow"));
        System.out.println(myBirthday4);
        long durationZDT = System.currentTimeMillis() - startTimeZDT; //конец для класса ZonedDateTime

        long startTimeCalendar = System.currentTimeMillis(); //начало для класса Calendar
        Calendar myBirthday5 = new GregorianCalendar(2000, JANUARY, 7, 3, 50, 15);
        System.out.println(myBirthday5.getTime());
        long durationCalendar = System.currentTimeMillis() - startTimeCalendar; //конец для класса Calendar

        long allTime = System.currentTimeMillis() - startTime; //конец для всей программы задания 1

        /**
         * 2) Для каждого класса из задания 1 создайте объект текущего времени
         * и сравните с датой вашего рождения соответствующего типа.
         * Выведите разницу на экран.
         */

        Date now = new Date();
        LocalDate now2 = LocalDate.now();
        LocalDateTime now3 = LocalDateTime.now();
        ZonedDateTime now4 = ZonedDateTime.now();
        Calendar now5 = GregorianCalendar.getInstance();

        int difference1 = (int) ((now.getTime() - myBirthday.getTime()) / (1000 * 60 * 60 * 24));
        System.out.println("Разница между текущей датой и днём моего рождения " + difference1 + " дней");

        Period difference2 = Period.between(myBirthday2, now2);
        System.out.printf("Разница между текущей датой и днём моего рождения %d года, %d месяцев и %d дней\n", difference2.getYears(), difference2.getMonths(), difference2.getDays());

        Duration difference3 = Duration.between(myBirthday3, now3);
        System.out.printf("Разница между текущей датой и днём моего рождения %d суток, или %d часов, или %d минут\n", difference3.toDays(), difference3.toHours(), difference3.toMinutes());

        LocalDate myBirthday4LD = myBirthday4.toLocalDate(); //Перевожу ZonedDateTime в LocalDate
        LocalDate now4LD = now4.toLocalDate(); //Перевожу ZonedDateTime в LocalDate
        Period difference4 = Period.between(myBirthday4LD, now4LD);
        System.out.printf("Разница между текущей датой и днём моего рождения %d года, %d месяцев и %d дней\n", difference4.getYears(), difference4.getMonths(), difference4.getDays());


        Date myBirthday5Date = myBirthday5.getTime(); //Перевожу из Calendar в Date
        Date now5Date = now5.getTime(); //Перевожу из Calendar в Date
        //Ну и дальше уже из Date в LocalDate, прости господи...
        LocalDate myBirthday5LD = myBirthday5Date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now5LD = now5Date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period difference5 = Period.between(myBirthday5LD, now5LD);
        System.out.printf("Разница между текущей датой и днём моего рождения %d года, %d месяцев и %d дней\n", difference5.getYears(), difference5.getMonths(), difference5.getDays());

        /**
         * 3) Посчитайте общее количество времени,
         * за которое выполняется программа из 1го задания
         * и выведите результат на экран.
         * Используйте класс по желанию.
         * Пример вывода:
         * Alltime - ms
         */

        System.out.println("Alltime - " + allTime + " ms");

        /**
         * 4) Аналогично 3му заданию, время выполнения в миллисекундах
         * (создание объекта + вывод на экран),
         * но для каждого класса из первого задания по отдельности.
         * Пример вывода:
         * Date - ms
         * LocalDate - ms
         * LocalDateTime - ms
         * ...
         * (для 5 классов из 1го задания)
         */

        System.out.println("Date - " + durationDate + " ms");
        System.out.println("LocalDate - " + durationLD + " ms");
        System.out.println("LocalDateTime - " + durationLDT + " ms");
        System.out.println("ZonedDateTime - " + durationZDT + " ms");
        System.out.println("Calendar - " + durationCalendar + " ms");
    }
}
