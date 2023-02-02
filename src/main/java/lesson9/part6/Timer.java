package lesson9.part6;

/**
 * Реализуйте класс Timer, который содержит:
 * - целочисленное поле seconds - общее число секунд, устанавливается в конструкторе
 * - статический метод void waitSecond() - метод реализует паузу одной секунды. Реализовать с помощью цикла.
 * - метод printTime вывода оставшегося времени в минутах и секундах.
 * - объектный метод start() - запускает обратный отсчет и каждую секунды выводит оставшееся количество секунд.
 *
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
        int minutes = seconds / 60;
        String minutesStr = minutes < 10 ? "0" + minutes : "" + minutes; //приводим минуты к формату 01, если минут меньше 10.
        seconds = seconds % 60;
        String secondsStr = seconds < 10 ? "0" + seconds : "" + seconds; //приводим секунды к формату 01, если секунд меньше 10.
        System.out.println(minutesStr + ":" + secondsStr);
    }

    public void start() {
        do {
            printTime(seconds);
            waitSecond();
            seconds -= 1;
        } while (seconds >= 0);
    }


}
