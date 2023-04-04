package lesson14.part1;

import lesson14.part1.basicElements.*;
import lesson14.part1.derivedElements.*;

public abstract class NatureElement {
    private String name;

    public String getName() {
        return name;
    }

    public abstract NatureElement connect(NatureElement element);

    public NatureElement(String name) {
        this.name = name;
    }

    /**
     *
     * @param name название элемента
     * @return создаёт новый базовый элемент по названию и возвращает его, если название известно
     * для неизвестных нназваний возвращает null
     */
    public static NatureElement create(String name) {
        switch (name) {
            case "Air":
                return new Air(name);
            case "Fire":
                return new Fire(name);
            case "Water":
                return new Water(name);
            case "Earth":
                return new Earth(name);
            default:
                System.out.println("Неизвестный элемент с именем " + name);
                return null;
        }
    }
}
