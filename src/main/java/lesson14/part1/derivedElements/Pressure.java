package lesson14.part1.derivedElements;

import lesson14.part1.NatureElement;

public class Pressure extends NatureElement {
    public Pressure(String name) {
        super(name);
    }

    @Override
    public NatureElement connect(NatureElement element) {
        System.out.println("Нет нового элемента");
        return null;
    }
}
