package lesson14.part1;

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
        for (int i = 0; i < args.length; i++) {
            if (NatureElement.create(args[i]) == null) {
                System.exit(1);
            }
            elements[i] = NatureElement.create(args[i]);
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
    }
}
