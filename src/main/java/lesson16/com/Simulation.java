package lesson16.com;

import lesson16.com.fruitbase.FruitBase;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Задание 5.6 часть 2
 * В проект фруктовой базы добавьте возможность через аргументы указать файл,
 * в который экспортировать или импортировать каталог.
 * Если после флага '-e' или '-i' следует '=', то каталог записывать или, соответственно,
 * считывается из файла по указанному пути.
 * Исключения обрабатываются в классе Simulation. При исключениях программа завершается со следующими сообщениями:
 * - если файл не найден (FileNotFoundException), то выводится сообщение: "Не найден файл "
 * - если происходит исключение при экспорте или импорте (IOException), то, например для экспорта -
 * "Ошибка при экспорте каталога в "
 * - если происходит чтение неподходящей версии файла, то сообщение
 * "Невозможно импортировать каталог из файла: неподдерживаемая версия"
 * - в остальных случаях сообщения для импорта и экспорта
 * "Непредвиденная ошибка при импорте каталога из файла"
 * "Непредвиденная ошибка при экспорте каталога из файла"
 */
public class Simulation {

    public static void handleExport(FruitBase base, String path) {
        try {
            base.exportCatalogue(path);
        } catch (FileNotFoundException ex) {
            System.out.println("Не найден файл");
            System.exit(2);
        } catch (IOException io) {
            System.out.println("Ошибка при экспорте каталога в " + path);
            System.exit(2);
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка при экспорте каталога из файла " + path);
            System.exit(2);
        }
    }

    public static void handleImport(FruitBase base, String path) {
        try {
            base.importCatalogue(path);
        } catch (FileNotFoundException ex) {
            System.out.println("Не найден файл");
            System.exit(3);
        } catch (IOException io) {
            System.out.println("Невозможно импортировать каталог из файла " + path + ": неподдерживаемая версия");
            System.exit(3);
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка при импорте каталога из файла " + path);
            System.exit(3);
        }
    }

    public static void main(String[] args) {
        FruitBase base = new FruitBase();
        if (args.length == 0) {
            System.out.println("Заказ отсутствует, введите данные.");
            System.exit(1);
        }

        if ((args[0].equals("-e") || args[0].equals("--export")) && args[1].equals("=") && args.length > 2) {
            handleExport(base, args[2]);
        } else if (args[0].equals("-e") || args[0].equals("--export")) {
            base.exportCatalogue();
        }
        if ((args[0].equals("-i") || args[0].equals("--import")) && args[1].equals("=") && args.length > 2) {
            handleImport(base, args[2]);
        } else if (args[0].equals("-i") || args[0].equals("--import")) {
            base.importCatalogue();
        }

    }
}
