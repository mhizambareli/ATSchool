package lesson16.part1.basicElements;

import lesson16.part1.NatureElement;
import lesson16.part1.derivedElements.Energy;
import lesson16.part1.derivedElements.Lava;
import lesson16.part1.derivedElements.Steam;

public class Fire extends NatureElement {
    public Fire(String name) {
        super(name);
    }

    /**
     * Обработка входного параметра для сложения огня с другими элементами
     * <p>
     * Fire + Fire не производит новый элемент
     * Fire + Air = Energy
     * Fire + Earth = Lava
     * Fire + Water = Steam
     *
     * @param element элемент, который добавляем к текущему элементу
     * @return новый результирующий элемент по результатам сложения
     */
    @Override
    public NatureElement connect(NatureElement element) {
        NatureElement result = null;
        if (element instanceof Fire) {
            System.out.println("Нет нового элемента");
        }
        if (element instanceof Air) {
            result = new Energy("Energy");
            System.out.println(this.getName() + " + " + element.getName() + " = " + result.getName());
        }
        if (element instanceof Earth) {
            result = new Lava("Lava");
            System.out.println(this.getName() + " + " + element.getName() + " = " + result.getName());
        }
        if (element instanceof Water) {
            result = new Steam("Steam");
            System.out.println(this.getName() + " + " + element.getName() + " = " + result.getName());
        }
        if (result == null) throw new UnsupportedOperationException();

        return result;
    }
}
