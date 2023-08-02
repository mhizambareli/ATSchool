package lesson16.part1.derivedElements;

import lesson16.part1.NatureElement;

public class Lava extends NatureElement {
    public Lava(String name) {
        super(name);
    }

    @Override
    public NatureElement connect(NatureElement element) {
        throw new UnsupportedOperationException();
    }
}
