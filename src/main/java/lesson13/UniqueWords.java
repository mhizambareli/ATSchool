package lesson13;

/**
 * Задание 75.1
 * Напишите программу, которая через аргументы командной строки получает "слова" (каждый аргумент - отдельное слово), печатает полученную последовательность слов, а потом выводит только уникальные слова из переданной последовательности.
 * Сохранять порядок символов в итоговом выводе необязательно.
 * <p>
 * Если в программу не переданы аргументы, то она завершается.
 * Пример:
 * 1)
 * Ввод: a aa abc a ab aa
 * Вывод:
 * a aa abc a ab aa
 * a aa ab abc
 * <p>
 * 2)
 * Ввод:
 * Вывод:
 */
public class UniqueWords {
    /**
     * Метод проверяет наличие конкретного слова в массиве
     *
     * @param arr  массив строк, в котором ищем слово
     * @param word конкретное слово, которое проверяем на наличие в массиве
     * @return
     */
    public static boolean containsWord(String[] arr, String word) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].equals(word)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }

        // Распечатываем переданные аргументы через пробел (первая строка вывода)
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]);
            if (i < args.length - 1) System.out.print(" ");
        }
        System.out.println();

        // Создаем новый массив, чтобы хранить в нём только уникальные слова
        String[] uniqueWords = new String[args.length];
        int index = 0;
        for (String word : args) {
            if (!containsWord(uniqueWords, word)) {
                uniqueWords[index] = word;
                index++;
            }
        }

        // Распечатываем уникальные слова через пробел(вторая строка вывода)
        for (int i = 0; i < index; i++) {
            System.out.print(uniqueWords[i]);
            if (i < index - 1) System.out.print(" ");
        }
    }
}