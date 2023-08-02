package lesson16.part1.derivedElements;

import lesson16.part1.NatureElement;

public class Dust extends NatureElement {

    public Dust(String name) {
        super(name);
    }

    @Override
    public NatureElement connect(NatureElement element) {
        throw new UnsupportedOperationException();
    }
}
