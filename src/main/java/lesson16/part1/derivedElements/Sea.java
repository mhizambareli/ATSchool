package lesson16.part1.derivedElements;

import lesson16.part1.NatureElement;

public class Sea extends NatureElement {
    public Sea(String name) {
        super(name);
    }

    @Override
    public NatureElement connect(NatureElement element) {
        throw new UnsupportedOperationException();
    }
}
