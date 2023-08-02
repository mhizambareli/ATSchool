package lesson10.part2;

/**
 * Через аругмент командной строки передается строка - путь до некоторого файла -
 * содержащая знак «/» или «\». Например, "/bin/java" или "C:\Program Files\Java\bin\java".
 * <p>
 * Напишите программу, которая для обоих вариантов разделителей, может вывести отдельно путь и имя файла.
 * Если имя файла отсутствует, т.е. строка оканчивается на "\" или "/",
 * то выдать ошибку: "Введен некорректный путь до файла."
 * <p>
 * Пример:
 * 1) Через аргументы передается "/bin/java", выводится:
 * Путь: /bin/
 * Имя файла: java
 * <p>
 * 2) Через аргументы передается "C:\Program Files\Java\bin\java", выводится:
 * Путь: C:\ProgramFiles\Java\bin\
 * Имя файла: java
 * <p>
 * 3) Через аргументы передается "/", выводится:
 * Введен некорректный путь до файла.
 * <p>
 * Проверку на наличие и корректность аргумента делать не надо.
 */
public class Main {

    public static void main(String[] args) {
        String path = args[0];
        char lastChar = path.charAt(path.length() - 1);
        if (lastChar == '\\' || lastChar == '/') {
            System.out.println("Введен некорректный путь до файла.");
            System.exit(1);
        }
        int index = 0; //переменная для хранения позиции слэша или обратного слэша в строке
        for (int i = 0; i < path.length() - 1; i++)
            if (path.charAt(i) == '\\' || path.charAt(i) == '/') index = i;
        System.out.printf("Путь: %s\nИмя файла: %s", path.substring(0, index + 1), path.substring(index + 1));
    }
}
