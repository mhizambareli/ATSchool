package lesson16.part1.derivedElements;

import lesson16.part1.NatureElement;
import lesson16.part1.basicElements.Air;
import lesson16.part1.basicElements.Earth;
import lesson16.part1.basicElements.Fire;
import lesson16.part1.basicElements.Water;

public class Energy extends NatureElement {
    public Energy(String name) {
        super(name);
    }

    /**
     * Обработка входного параметра для сложения энергии с другими элементами
     * <p>
     * Energy + Water = Steam
     *
     * @param element элемент, который добавляем к текущему элементу
     * @return новый результирующий элемент по результатам сложения
     */
    @Override
    public NatureElement connect(NatureElement element) {
        NatureElement result = null;
        if (element instanceof Water) {
            result = new Steam("Steam");
            System.out.println(this.getName() + " + " + element.getName() + " = " + result.getName());
        }
        if (result == null) throw new UnsupportedOperationException();
        return result;
    }
}
