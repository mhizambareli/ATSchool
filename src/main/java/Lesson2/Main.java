package Lesson2;

/** Задание 2.1. Создать класс Circle, который содержит
 *  - переменную radius;
 *  - методы, вычисляющие площадь и длину окружности;
 *  - константу PI.
 * Создать несколько объектов данного класса и вывести на экран:
 * радиус - площадь - длина окружности
 */
public class Main {
    public static void main(String[] args) {

        Circle first = new Circle(5);
        first.findPerimeter(first.getRadius());
        first.findArea(first.getRadius());

        //Радиус объекта переопределён через сеттер
        Circle second = new Circle(10);
        second.setRadius(15);
        second.findPerimeter(second.getRadius());

        Circle third = new Circle(3);
        third.findPerimeter(third.getRadius());
        third.findArea(third.getRadius());


        //Проверка с радиусом 0
        Circle fourth = new Circle(0);
        fourth.findArea(fourth.getRadius());
        fourth.findPerimeter(fourth.getRadius());

        //Проверка исключений
        Circle fifth = new Circle(1);
        fifth.setRadius(-10); //исключение в сеттере

        Circle sixth = new Circle(-2);
    }
}
