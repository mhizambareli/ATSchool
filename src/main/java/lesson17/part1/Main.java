package lesson17.part1;

/**
 * Задание 6.4.1
 * Добавьте в первое задание 4.4 обработку новых операций:
 * - используя анонимный класс, добавьте операцию Wave: к каждому числу прибавляется значение предыдущего.
 *   К первому элементу прибавляется 0.
 *   Пример:
 *   Переданные аругменты: Wave 1 2 4 8
 *   Вывод:
 *   1 2 4 8
 *   1 3 6 12
 *
 * - используя лямбда-выражение, добавьте операцию SquareEven: каждое четное число возводится в квадрат.
 *   Пример:
 *   Переданные аругменты: SquareEven 1 2 3 4
 *   Вывод:
 *   1 2 3 4
 *   1 4 3 16
 */
public class Main {
    /**
     * Метод применения функции над массивом целых чисел
     *
     * @param arr массив переданных чисел
     * @param func объект типа Function
     * @return новый массив, числа в массиве измененены в соответствии с операцией
     */
    public static int[] applyFunction(int[] arr, Function func) {
        for(int i = 0; i < arr.length; i++){
            arr[i] = func.evaluate(arr[i]);
        }
        return arr;
    }

    public static void printArray(int[] arr){
        String result = "";
        for(int elem : arr) {
            result += elem + " ";
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Не передано название операции.");
            return;
        }
        Function function;
        switch (args[0]) {
            case "Half":
                function = new Half();
                break;
            case "Double":
                function = new Double();
                break;
            case "Exact":
                function = new Exact();
                break;
            case "Square":
                function = new Square();
                break;
            case "Wave":
                function = new Function() {
                    int result = 0;
                    int previous = 0;
                    @Override
                    public int evaluate(int x) {
                        result = x + previous;
                        previous = x;
                        return result;
                    }
                };
                break;
            case "SquareEven":
                function = (a) -> {
                    if (a % 2 == 0) a = a * a;
                    return a;
                };
                break;
            default:
                System.out.println("Операция " + args[0] + " не поддерживается.");
                return;
        }
        if (args.length == 1) {
            System.out.println("Не переданы числа для операции.");
            return;
        }
        int[] array = new int[args.length - 1];

        for(int i = 0, j = 1; j < args.length; i++, j++){
            array[i] = Integer.parseInt(args[j]);
        }
        printArray(applyFunction(array, function));
    }
}
