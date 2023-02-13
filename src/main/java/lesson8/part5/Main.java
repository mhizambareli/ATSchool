package lesson8.part5;

/**
 * Товар стоит a руб. b коп. За него заплатили c руб. d коп.
 *
 * Напишите программу, расчитывающую сдачу.
 * Целые числа a, b, c, d передаются через аргументы командной строки.
 *
 * Проверку на наличие аргументов делать не надо.
 * Нужно добавить проверку, что числа больше или равны нулю.
 * В противном случае нужно вывести пользователю сообщение об ошибке и завершить программу.
 * Так же нужно проверить, что уплаченной суммы хватает для оплаты товара.
 * В противном случае нужно вывести соответствующее сообщение и завершить программу.
 *
 * Формат вывода:
 * Сдача составит e рублей и f копеек.
 */
public class Main {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int d = Integer.parseInt(args[3]);
        int priceInCents = a * 100 + b; //переводим в копейки
        int paymentInCents = c * 100 + d; //переводим в копейки

        if (a < 0 || b < 0 || c < 0 || d < 0) System.out.println("Введены неверные значения.");
        else {
            System.out.printf("Товар стоит %d руб. %d коп. За него заплатили %d руб. %d коп.\n", a, b, c, d);
            if (priceInCents > paymentInCents) System.out.println("Не хватает денег для оплаты товара.");
            else {
                int changeInCents = paymentInCents - priceInCents;
                int e = changeInCents / 100;
                int f = changeInCents % 100;
                System.out.printf("Сдача составит %d рублей и %d копеек.", e, f);
            }
        }
    }
}
