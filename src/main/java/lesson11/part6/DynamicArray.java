package lesson11.part6;

/**
 * Напишите класс DynamicArray - класс, реализующий массив целых чисел с изменяемым размером.
 * Для хранения значений используется внутренний приватный обычный массив.
 * <p>
 * У данного класса нужно реализовать:
 * - конструктор с целочисленным параметром - начальным размером массива
 * создает внутренний массив указанного размера
 * - конструктор с параметром-массивом
 * создает внутреннюю копию переданного массива
 * <p>
 * Класс также должен реализовать методы:
 * - String toString() - возвращает строку, где все элементы массива в строку записаны через пробел
 * - void add(int x) - добавить один элемент в конец внутреннего массива
 * - void add(int[] x) - добавить элементы из переданного массива в конец внутреннего
 * - int getAt(int n) - получить один элемент массива с позиции n
 * - int[] get(int from, int to) - получить массив элементов с начиная с позиции from до to,
 * не включая to. Например, при вызове get(0, 5) метод должен вернуть массив
 * с элементами из внутреннего приватного с индексами: 0, 1, 2, 3, 4
 * - void delete(int n) - удалить элемент из массива на позиции n
 * - void deleteAll()- удалить все элементы
 * <p>
 * Напишите программу, которая:
 * - получает через аргументы командной строки целочисленные значения,
 * - создает объект DynamicArray
 * - добавляет в него переданные элементы
 * - печатает полученный объект
 * - создает второй объект DynamicArray
 * - копирует все значения из первого во второй
 * - удаляет один элемент второго объекта
 * - печатает элементы первого объекта
 * - печатает элементы второго объекта
 */
public class DynamicArray {
    private int[] innerArr;

    public int[] getInnerArr() {
        return innerArr;
    }

    public DynamicArray(int n) {
        innerArr = new int[n];
    }

    public DynamicArray(int... innerArr) {
        this.innerArr = innerArr;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i : innerArr) {
            result += i + " ";
        }
        return result;
    }

    /**
     * Метод добавляет один элемент в конец внутреннего массива
     *
     * @param x элемент, который нужно добавить в конец массива
     */
    void add(int x) {
        int[] copy = new int[innerArr.length + 1];
        int i;
        for (i = 0; i < innerArr.length; i++) {
            copy[i] = innerArr[i];
        }
        copy[i] = x;
        innerArr = copy;
    }

    /**
     * Метод добавляет элементы из переданного массива в конец внутреннего
     *
     * @param x массив, элементы которого нужно добавить в конец внутреннего массива
     */
    void add(int[] x) {
        if (x.length == 0) return; //для массива нулевой длины сразу выходим, бессмысленно клонировать и т.д.
        if (innerArr.length == 0) {
            innerArr = x; //для внутреннего массива нулевой длины тоже бессмысленно делать лишние действия, просто меняем ссылку
            return;
        }
        int[] copy = new int[innerArr.length + x.length];
        int i;
        for (i = 0; i < innerArr.length; i++) {
            copy[i] = innerArr[i];
        }
        for (int j = 0; i < copy.length; i++, j++) {
            copy[i] = x[j];
        }
        innerArr = copy;
    }

    /**
     * Метод позволяет получить один элемент массива с позиции n. При n = 1 будет выдан первый элемент под индексом 0.
     *
     * @param n позиция элемента, который хотим получить из массива
     * @return значение, которое лежит в массиве на указанной позиции
     */
    int getAt(int n) {
        if (n > innerArr.length) {
            System.out.print("В массиве всего " + innerArr.length + " элементов, невозможно взять " + n + "-й элемент. ");
            return 0;
        }
        return innerArr[n - 1];
    }

    /**
     * Метод позволяет получить массив элементов с начиная с позиции from до to, не включая to.
     * Например, при вызове get(0, 5) метод должен вернуть массив с элементами из внутреннего приватного с индексами: 0, 1, 2, 3, 4
     *
     * @param from индекс массива, с которого нужно начать изъятие
     * @param to   индекс массива, на котором нужно остановиться, не включая его.
     * @return новый массив с выбранными элементами
     */
    int[] get(int from, int to) {
        if (from < 0 || from >= to || innerArr.length < to) return new int[0];
        int[] result = new int[to - from];
        for (int i = from, j = 0; i < to; i++, j++) {
            result[j] = innerArr[i];
        }
        return result;
    }

    /**
     * Метод удаляет элемент из массива innerArr на позиции n. При n = 1 будет удалён первый элемент под индексом 0.
     *
     * @param n позиция элемента, который хотим удалить из массива
     */
    void delete(int n) {
        if (innerArr.length < n || n == 0) return;
        int[] copy = new int[innerArr.length - 1];
        for (int i = 0, j = 0; i < innerArr.length; i++) {
            if (i == n - 1)
                continue; //уходим на следующую итерацию цикла, не добавляем удаляемый элемент в новый массив, не увеличиваем j.
            copy[j] = innerArr[i];
            j++;
        }
        innerArr = copy;
    }

    /**
     * Метод удаляет все элементы из внутреннего массива innerArr
     */
    void deleteAll() {
        innerArr = new int[0];
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Для начала работы программы передайте, пожалуйста, аргументы.");
            System.exit(1);
        }
        int[] x = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            x[i] = Integer.parseInt(args[i]);
        }

        DynamicArray array1 = new DynamicArray(x);
        System.out.println("Элементы из первого объекта: " + array1.toString());
        DynamicArray array2 = new DynamicArray(array1.getInnerArr()); //внутри класса можно было и без геттера, но пусть будет
        array2.delete(2);
        System.out.println("Ещё раз элементы первого объекта: " + array1.toString());
        System.out.println("Элементы второго объкта: " + array2.toString());
    }
}
