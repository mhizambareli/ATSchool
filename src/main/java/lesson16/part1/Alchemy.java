package lesson16.part1;

import lesson16.part1.basicElements.Water;
import lesson16.part1.derivedElements.Energy;
import lesson16.part1.derivedElements.Mud;

import java.util.NoSuchElementException;

/**
 * класс Alchemy
 * метод main
 * через аргументы командной строки передаются названия элементов
 * для переданных аргументов создаются объекты соответствующих классов.
 * Если хотя бы для одного из аргументов нельзя создать объект, то программа завершается.
 * Далее попарно объединяются объекты и выводятся соответствующие сообщения.
 * Т.е. для объектов Air Air Fire Earth в результате объединения получатся два объекта: Pressure и Lava
 */
public class Alchemy {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Смешивать нечего, даже не поколдуешь :(");
            System.exit(1);
        }
        //Создаём массив с элементами, проверяем что для всех переданных аргументов возможно создать элемент
        NatureElement[] elements = new NatureElement[args.length];
        try {
            for (int i = 0; i < args.length; i++) {
                elements[i] = NatureElement.create(args[i]);
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.exit(2);
        }


        //делим массив на пары по 2 элемента для сложения/объединения в новые элементы
        if (elements.length % 2 == 0) { //для чётного кол-ва элементов
            for (int i = 0; i < elements.length; i += 2) {
                elements[i].connect(elements[i + 1]);
            }
        } else {
            for (int i = 0; i < elements.length - 1; i += 2) { //для нечётного кол-ва элементов последний не трогаем
                elements[i].connect(elements[i + 1]);
            }
        }

        //проверяю новые операции объединения элементов, выбрасываемые исключения и то, что они не останавливают работу программы
        NatureElement energy = new Energy("Energy");
        NatureElement water = new Water("Water");
        NatureElement mud = new Mud("Mud");

        try {
            energy.connect(water); //Energy + Water = Steam
        } catch (UnsupportedOperationException e) {
            System.out.println("Операция не поддерживается");
            e.printStackTrace();
        }

        try {
            energy.connect(mud); //Исключение
        } catch (UnsupportedOperationException e) {
            System.out.println("Операция не поддерживается");
            e.printStackTrace();
        }
        try {
            mud.connect(water); //Исключение
        } catch (UnsupportedOperationException e) {
            System.out.println("Операция не поддерживается");
            e.printStackTrace();
        }

        try {
            water.connect(energy); //Water + Energy = Steam
        } catch (UnsupportedOperationException e) {
            System.out.println("Операция не поддерживается");
            e.printStackTrace();
        }
    }
}
