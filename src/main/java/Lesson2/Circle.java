package Lesson2;

/**
 * Класс Circle представляет круг
 */
public class Circle {
    private static final double PI = 3.14159; // значение числа ПИ
    private int radius; // значение радиуса окружности

    //Конструктор
    Circle(int radius) {
        this.setRadius(radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Радиус круга не может быть отрицательным");
        }
        this.radius = radius;
    }

    /**
     * Метод вычисления длины окружности по радиусу
     * @param radius - радиус окружности
     */
    public void findPerimeter(int radius) {
        if(radius == 0) {
            System.out.println("Чел, я точка, а не окружность, прекрати, у меня нет длины");
        }
        else {
            double perimeter = 2 * PI * radius;
            System.out.printf("Длина окружности с радиусом %d равна %f\n", radius, perimeter);
        }
    }

    /**
     * Метод вычисления площади круга по радиусу
     * @param radius - радиус окружности
     */
    public void findArea(int radius) {
        if (radius == 0) {
            System.out.println("Я не круг, а точка, мне площадь не завезли:(");
        }
        else {
            double area = PI * radius * radius;
            System.out.printf("Площадь круга с радиусом %d равна %f\n", radius, area);
        }
    }
}
