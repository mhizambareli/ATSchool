package lesson8.part4;

import static java.util.Arrays.sort;

/**
 * В программу через аргументы командной строки передаются
 * три натуральных числа – стороны треугольника.
 *
 * Необходимо определить тип треугольника с данными сторонами
 * (остроугольный, тупоугольный, прямоугольный)
 * вывести одно из слов:
 * - right для прямоугольного треугольника (если с^2 = a^2 + b^2, где с - наибольшая сторона),
 * - acute для остроугольного треугольника (если с^2 < a^2 + b^2, где с - наибольшая сторона),
 * - obtuse для тупоугольного треугольника (если с^2 > a^2 + b^2, где с - наибольшая сторона)
 * - или impossible, если входные числа не образуют треугольника.
 *
 * Стороны сторон передаются через аргументы командной строки.
 * Проверку на наличие аргументов делать не надо.
 */
public class Main {

    public static void main(String[] args) {
        //принимаемые аргументы сразу сортируем для удобства, чтобы переменная c была равна наибольшему значению.
        int[] intArr = {Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])};
        sort(intArr);
        int a = intArr[0];
        int b = intArr[1];
        int c = intArr[2];
        double aSqr = a * a;
        double bSqr = b * b;
        double cSqr = c * c;

        //сначала проверки на то, что треугольник не существует, и если всё-таки существует, то проверки на то, какой угол.
        if ((a + b <= c) || (b + c <= a) || (a + c <= b) || (a <= 0) || (b <= 0) || (c <= 0))
            System.out.println("impossible");
        else {
            if (aSqr + bSqr == cSqr) System.out.println("right");
            if (aSqr + bSqr < cSqr) System.out.println("obtuse");
            if (aSqr + bSqr > cSqr) System.out.println("acute");
        }
    }
}
