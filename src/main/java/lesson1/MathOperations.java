package lesson1;

import java.math.BigDecimal;
import java.math.BigInteger;
import static java.math.RoundingMode.DOWN;

/**
* Задание 1. Сделать основные арифметические действия:
* 1) плюс
* 2) минус
* 3) умножить
* 4) разделить без остатка
* 5) получить остаток от деления.
* С ОЧЕНЬ большими числами (>20 знаков) как с целочисленными так и с плавающей точкой.
* 1) Использовать типы BigDecimal и BigInteger
* 2) Для решения задания потребуется создать отдельный класс с методом main и в этом методе выполнить все перечисленные действия.
*/
public class MathOperations {
    public static void main(String[] args) {
        BigDecimal firstDec = new BigDecimal("123456789.101112131415");
        BigDecimal secondDec = new BigDecimal("15141312.1110987654321");
        BigInteger firstInt = new BigInteger("111662444152591551770");
        BigInteger secondInt = new BigInteger("890596914953000786321");

        // операции с числами с плавающей точкой
        BigDecimal sumOfDec = firstDec.add(secondDec);
        BigDecimal diffOfDec = secondDec.subtract(firstDec);
        BigDecimal prodOfDec = firstDec.multiply(secondDec);
        BigDecimal quotOfDec = secondDec.divide(firstDec, DOWN);
        BigDecimal remOfDec = firstDec.remainder(secondDec);

        // операции с целыми числами
        BigInteger sumOfInt = firstInt.add(secondInt);
        BigInteger diffOfInt = firstInt.subtract(secondInt);
        BigInteger prodOfInt = secondInt.multiply(firstInt);
        BigInteger quotOfInt = secondInt.divide(firstInt);
        BigInteger remOfInt = secondInt.mod(firstInt);

        System.out.printf("Сумма двух чисел с плавающей точкой:\n%s + %s = %s\n", firstDec, secondDec, sumOfDec);
        System.out.printf("Сумма двух целых чисел:\n%s + %s = %s\n", firstInt, secondInt, sumOfInt);
        System.out.printf("Разница между вторым и первым числом с плавающей точкой:\n%s - %s = %s\n", secondDec, firstDec, diffOfDec);
        System.out.printf("Разница между первым и вторым целым числом:\n%s - %s = %s\n", firstInt, secondInt, diffOfInt);
        System.out.printf("Произведение двух чисел с плавающей точкой:\n%s * %s = %s\n", firstDec, secondDec, prodOfDec);
        System.out.printf("Произведение двух целых чисел:\n%s * %s = %s\n", firstInt, secondInt, prodOfInt);
        System.out.printf("Частное второго и первого числа с плавающей точкой:\n%s / %s = %s\n", secondDec, firstDec, quotOfDec);
        System.out.printf("Частное второго и первого целого числа:\n%s / %s = %s\n", secondInt, firstInt, quotOfInt);
        System.out.printf("Остаток от деления чисел с плавающей точкой:\n%s %% %s = %s\n", firstDec, secondDec, remOfDec);
        System.out.printf("Остаток от деления целых чисел:\n%s %% %s = %s\n", secondInt, firstInt, remOfInt);
    }
}
