package lesson4.ru.pflb.details;

/**
 * Создать класс Engine в пакете ru.pflb.details
 * содержит поля:
 * power - значение мощности двигателя в ваттах
 * vendor - название производителя
 * - toString - возвращает строку с информацией о двигателе
 * Формат вывода:
 * <vendor> - <мощность>
 */
public class Engine {
    private int power;
    private String vendor;

    public int getPower() {
        return power;
    }

    public String getVendor() {
        return vendor;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    /**
     * Конструктор класса Engine
     *
     * @param vendor - наименование производителя
     * @param power  - мощность двигателя в ваттах
     */
    public Engine(String vendor, int power) {
        this.vendor = vendor;
        this.power = power;
    }

    @Override
    public String toString() {
        return vendor + " - " + power + " ватт";
    }
}
