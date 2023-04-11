package lesson15.part2.com.fruitbase;

import java.io.*;

/**
 * Добавьте в программу по фруктовой базе возможность импорта/экспорта каталога фруктов.
 * Добавьте в класс FruitBase следующие методы:
 * - общедоступный метод exportCatalogue
 * Сериализует внутренний объект FruitCatalogue в проект.
 * Выводится сообщение "каталог экспортирован"
 * <p>
 * - общедоступный метод importCatalogue
 * Десериализует из проекта объект FruitCatalogue и результатом заменяет текущий внутренний объект.
 * Выводится сообщение "каталог импортирован"
 */
public class FruitBase implements Serializable {
    private static final long serialVersionUID = 1L;
    private FruitCatalogue catalogue;
    private Cargo cargo;

    public Cargo getCargo() {
        return cargo;
    }

    public FruitBase() {
        catalogue = new FruitCatalogue();
    }

    /**
     * Метод принимает заказ, формирует груз, проверяет наличие позиций в каталоге, после чего печатает реальное содержимое заказа.
     *
     * @param order массив строк, который содержит в себе какие-то названия для заказа
     */
    public void takeOrder(String[] order) {
        cargo = new Cargo();
        for (String fruit : order) {
            if (catalogue.findFruit(fruit) != null) {
                cargo.addFruit(catalogue.findFruit(fruit));
            }
        }
        System.out.println(cargo);
    }

    /**
     * Метод сериализует и экспортирует (сохраняет файл в ресурсы) каталог фруктов из конкретного объекта фруктовой базы
     */
    public void exportCatalogue() {
        try (FileOutputStream outputStream = new FileOutputStream("src/main/resources/FruitCatalog.ser")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(this.catalogue);
            objectOutputStream.close();
            System.out.println("Каталог экспортирован\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод десериализует и импортирует (достаёт файл из рерурсов) значение для переменной catalogue конкретного объекта фруктовой базы
     */
    public void importCatalogue() {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/FruitCatalog.ser")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            this.catalogue = (FruitCatalogue) objectInputStream.readObject();
            System.out.println("Каталог импортирован\n");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public FruitCatalogue getCatalogue() {
        return catalogue;
    }
}
