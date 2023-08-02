package lesson16.part1.derivedElements;

import lesson16.part1.NatureElement;

public class Mud extends NatureElement {
    public Mud(String name) {
        super(name);
    }

    @Override
    public NatureElement connect(NatureElement element) {
        throw new UnsupportedOperationException();
    }
}
