package lesson16.part1;

import lesson16.part1.basicElements.Air;
import lesson16.part1.basicElements.Earth;
import lesson16.part1.basicElements.Fire;
import lesson16.part1.basicElements.Water;

import java.util.NoSuchElementException;

public abstract class NatureElement {
    private String name;

    public String getName() {
        return name;
    }

    public abstract NatureElement connect(NatureElement element) throws UnsupportedOperationException;

    public NatureElement(String name) {
        this.name = name;
    }

    /**
     *
     * @param name название элемента
     * @return создаёт новый базовый элемент по названию и возвращает его, если название известно.
     * Для неизвестных названий выкидывает исключение NoSuchElementException
     */
    public static NatureElement create(String name) throws NoSuchElementException {
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
                throw new NoSuchElementException();
        }
    }
}
