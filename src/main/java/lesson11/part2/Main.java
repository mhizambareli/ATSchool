package lesson11.part2;

/**
 * Через аргументы командной строки передаются "слова" - последовательность строчных латинских букв и цифр. Каждый аргумент - отдельное "слово".
 * Напишите программу, которая выводит слова наибольшей длины.
 * <p>
 * Сделайте проверку на наличие аргументов командной строки.
 * Если аргументы не переданы, то выведите соответствующее сообщение и завершите программу.
 * Сделайте проверку, что "слова" состоят только из строчных латинских букв и цифр.
 * Иначе выведите сообщение об ошибке и завершите программу.
 * <p>
 * Например:
 * Ввод: 123 abcd b33f 0s 12
 * Вывод: abcd b33f
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Аргументы командной строки не были переданы.");
            return;
        }

        int maxLength = 0; //максимальная длина слов во всём массиве args[]
        int numLongestWords = 0; //количество слов в массиве с максимальной длиной

        String[] words = new String[args.length];
        for (String word : args) {
            if (!word.matches("[a-z0-9]+")) {
                System.out.println("Слова должны состоять только из строчных латинских букв и цифр.");
                return;
            }
            int length = word.length(); //длина конкретного слова из массива args[]
            if (length > maxLength) {
                maxLength = length;
                numLongestWords = 1;
                words[0] = word;
            } else if (length == maxLength) {
                words[numLongestWords] = word;
                numLongestWords++;
            }
        }

        for (int i = 0; i < numLongestWords; i++) {
            System.out.println(words[i] + " ");
        }
    }
}