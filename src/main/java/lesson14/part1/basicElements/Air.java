package lesson14.part1.basicElements;

import lesson14.part1.NatureElement;
import lesson14.part1.derivedElements.Dust;
import lesson14.part1.derivedElements.Energy;
import lesson14.part1.derivedElements.Pressure;
import lesson14.part1.derivedElements.Rain;

public class Air extends NatureElement {
    public Air(String name) {
        super(name);
    }

    /**
     * Обработка входного параметра для сложения воздуха с другими элементами
     * <p>
     * Air + Air = Pressure
     * Air + Earth = Dust
     * Air + Fire = Energy
     * Air + Water = Rain
     *
     * @param element элемент, который добавляем к текущему элементу
     * @return новый результирующий элемент по результатам сложения
     */
    @Override
    public NatureElement connect(NatureElement element) {
        NatureElement result = null;
        if (element instanceof Air) {
            result = new Pressure("Pressure");
            System.out.println(this.getName() + " + " + element.getName() + " = " + result.getName());
        }
        if (element instanceof Earth) {
            result = new Dust("Dust");
            System.out.println(this.getName() + " + " + element.getName() + " = " + result.getName());
        }
        if (element instanceof Fire) {
            result = new Energy("Energy");
            System.out.println(this.getName() + " + " + element.getName() + " = " + result.getName());
        }
        if (element instanceof Water) {
            result = new Rain("Rain");
            System.out.println(this.getName() + " + " + element.getName() + " = " + result.getName());
        }
        return result;
    }
}
