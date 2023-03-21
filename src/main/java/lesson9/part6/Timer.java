package lesson9.part6;

/**
 * Реализуйте класс Timer, который содержит:
 * - целочисленное поле seconds - общее число секунд, устанавливается в конструкторе
 * - статический метод void waitSecond() - метод реализует паузу одной секунды. Реализовать с помощью цикла.
 * - метод printTime вывода оставшегося времени в минутах и секундах.
 * - объектный метод start() - запускает обратный отсчет и каждую секунды выводит оставшееся количество секунд.
 * <p>
 * Нужно проверить, что введенное число seconds больше нуля или равно нулю.
 * В противном случае выведите сообщение об ошибке и завершите программу.
 */
public class Timer {
    int seconds;

    public Timer(int seconds) {
        if (seconds < 0) {
            System.out.println("Введите неотрицательное целое число, чтобы задать секунды. На " + seconds + " секунд таймер поставить невозможно.");
            System.exit(0);
        }
        this.seconds = seconds;
    }

    public static void waitSecond() {
        long timeToStop = System.currentTimeMillis() + 1000;
        while (System.currentTimeMillis() < timeToStop) ;
    }

    public void printTime(int seconds) {
        System.out.printf("%02d:%02d\n", seconds / 60, seconds % 60);
    }

    public void start() {
        for (; seconds > 0; seconds--) {
            printTime(seconds);
            waitSecond();
        }
        //в случае, если осталось 0 секунд, секундная пауза больше не нужна, просто печатаем время
        if (seconds == 0) printTime(seconds);
    }
}
