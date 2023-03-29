package lesson13.com.fruitbase;


public class FruitBase {
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
}
