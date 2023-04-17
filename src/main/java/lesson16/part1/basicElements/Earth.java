package lesson16.part1.basicElements;

import lesson16.part1.NatureElement;
import lesson16.part1.derivedElements.Dust;
import lesson16.part1.derivedElements.Lava;
import lesson16.part1.derivedElements.Mud;
import lesson16.part1.derivedElements.Pressure;

public class Earth extends NatureElement {
    public Earth(String name) {
        super(name);
    }

    /**
     * Обработка входного параметра для сложения земли с другими элементами
     * <p>
     * Earth + Earth = Pressure
     * Earth + Air = Dust
     * Earth + Fire = Lava
     * Earth + Water = Mud
     *
     * @param element лемент, который добавляем к текущему элементу
     * @return новый результирующий элемент по результатам сложения
     */
    @Override
    public NatureElement connect(NatureElement element) {
        NatureElement result = null;
        if (element instanceof Air) {
            result = new Dust("Dust");
            System.out.println(this.getName() + " + " + element.getName() + " = " + result.getName());
        }
        if (element instanceof Earth) {
            result = new Pressure("Pressure");
            System.out.println(this.getName() + " + " + element.getName() + " = " + result.getName());
        }
        if (element instanceof Fire) {
            result = new Lava("Lava");
            System.out.println(this.getName() + " + " + element.getName() + " = " + result.getName());
        }
        if (element instanceof Water) {
            result = new Mud("Mud");
            System.out.println(this.getName() + " + " + element.getName() + " = " + result.getName());
        }
        return result;
    }
}
