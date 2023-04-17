package lesson16.part1.derivedElements;

import lesson16.part1.NatureElement;

public class Steam extends NatureElement {
    public Steam(String name) {
        super(name);
    }

    @Override
    public NatureElement connect(NatureElement element) {
        System.out.println("Нет нового элемента");
        return null;
    }
}
