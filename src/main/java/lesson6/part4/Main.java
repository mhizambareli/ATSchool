package lesson6.part4;

import org.jetbrains.annotations.NotNull;

/**
 * Напишите программу, которая вычисляет и выводит сумму, которую вы получите через t лет при размещении суммы P на счете под ежегодный процент r.
 * Это расчитывается по формуле: P*e^(r*t).
 * Для вычисления экспоненты воспользуйтесь функцией стандартной библиотеки Math.exp(). Значение суммы P, процент r и кол-во лет t необходимо получать через аргументы командной строки.
 * Проверку на кол-во введенных аргументов делать не надо.
 *
 * Например:
 * 1)Дано: P = 40000, r = 5, t = 5
 * 51361.016667509655
 *
 * Или можете процент сделать в виде десятичной дроби
 * 2)Дано: P = 40000, r = 0.05, t = 5
 * 51361.016667509655
 */

/**
 * ежегодный процент r в моей реализации принимается в формате "5", в методе идёт приведение к формату 0.05 для расчёта
 * при вводе r = 0.05, результат будет посчитан как 0.05%, т.е пять сотых процента в год
 */
public class Main {
    public static String countDeposit(double P, double r, double t) {
        String given = "Дано: P = " + P + ", r = " + r + ", t = " + t + "\n";
        r = r / 100; //для перевода 5% в формат 0.05 для формулы
        double result = P * Math.exp(r * t);
        return given + result;
    }

    public static void main(String [] args) {
        //парсим данные в double, т.к. в main() аргументы принимаются в String
        double P = Double.parseDouble(args[0]);
        double r = Double.parseDouble(args[1]);
        double t = Double.parseDouble(args[2]);
        System.out.println(countDeposit(P, r, t));
    }
}
