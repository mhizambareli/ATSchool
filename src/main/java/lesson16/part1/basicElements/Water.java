package lesson16.part1.basicElements;

import lesson16.part1.NatureElement;
import lesson16.part1.derivedElements.*;

import java.util.NoSuchElementException;

public class Water extends NatureElement {
    public Water(String name) {
        super(name);
    }

    /**
     * Обработка входного параметра для сложения воды с другими элементами
     * <p>
     * Water + Water = Sea
     * Water + Fire = Steam
     * Water + Earth = Mud
     * Water + Air = Rain
     * Water + Energy = Steam
     *
     * @param element элемент, который добавляем к текущему элементу
     * @return новый результирующий элемент по результатам сложения
     */
    @Override
    public NatureElement connect(NatureElement element) {
        NatureElement result = null;
        if (element instanceof Air) {
            result = new Rain("Rain");
            System.out.println(this.getName() + " + " + element.getName() + " = " + result.getName());
        }
        if (element instanceof Earth) {
            result = new Mud("Mud");
            System.out.println(this.getName() + " + " + element.getName() + " = " + result.getName());
        }
        if (element instanceof Fire) {
            result = new Steam("Steam");
            System.out.println(this.getName() + " + " + element.getName() + " = " + result.getName());
        }
        if (element instanceof Water) {
            result = new Sea("Sea");
            System.out.println(this.getName() + " + " + element.getName() + " = " + result.getName());
        }
        if (element instanceof Energy) {
            result = new Steam("Steam");
            System.out.println(this.getName() + " + " + element.getName() + " = " + result.getName());
        }
        if (result == null) throw new UnsupportedOperationException();

        return result;
    }
}
