package Lesson3.realisation1;

/**
 * В методе main создать 3 разные недели и вывести всю информацию о них (для ориентира за год считать 2022)
 * Формат вывода:
 * Неделя {номер недели}:
 * День - Число
 * День - Число
 */
public class Main {
    public static void main(String[] args) {
        Week firstWeek = new Week(6, 7, 8, 9, 10, 11, 12, 13);
        Week secondWeek = new Week(37, 12, 13, 14, 15, 16, 17, 18);
        Week thirdWeek = new Week(48, 28, 29, 30, 1, 2, 3, 4);

        System.out.println(firstWeek);
        System.out.println(secondWeek);
        System.out.println(thirdWeek);
    }
}
