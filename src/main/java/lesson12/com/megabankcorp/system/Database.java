package lesson12.com.megabankcorp.system;

import lesson12.com.megabankcorp.records.Account;

import java.math.BigDecimal;

/**
 * ЗАДАНИЕ 64.1:
 * Представим, что вы занимаетесь проектированием банковской системы учета.
 * Ваша задача описать базовые классы, на основании которых могут делаться остальные.
 * Спроектируйте классы Account (счет) и Database (база данных) согласно описанию:
 *
 * Database
 *     Этот класс является абстрактным шаблоном для реализаций,
 *     которые будут создаваться в виде наследников этого класса.
 *     В нем находятся методы, которые наследники обязаны реализовать.
 *     Или реализации методов по-умолчанию.
 *     Вам наследников реализовывать не надо.
 *
 *     находится в пакете com.megabankcorp.system
 *     содержит заготовки методов
 *         - deposit - сохраняет указанную сумму на указанный счет
 *             не содержит реализации, просто сигнатура с описанием
 *             доступен отовсюду
 *
 *         - withdraw - забирает указанную сумму на указанный счет
 *             не содержит реализации, просто сигнатура с описанием
 *             доступен отовсюду
 *
 *         - getAmount - получает значение суммы с указанного счета
 *             не содержит реализации, просто сигнатура с описанием
 *             доступен только из пакета и реализаций
 *
 *         - transfer - передает указанную сумму с одного указанного счета на другой
 *             содержит реализацию по умолчанию, использующую методы deposit и withdraw
 *             доступен только из пакета
 *
 *     Для суммы используйте тип BigDecimal.
 *     Для параметров счетов используете класс Account
 */
public abstract class Database {
    /**
     * Метод добавляет указанную сумму на указанный счет
     *
     * @param sum сумма, которую нужно внести на счёт
     * @param acc объект класса Account, с которым будет взаимодействие (увеличение суммы счёта)
     */
    public abstract void deposit(BigDecimal sum, Account acc);

    /**
     * Метод снимает указанную сумму с указанного счёта
     *
     * @param sum сумма, которую нужно снять со счёта
     * @param acc объект класса Account, с которым будет взаимодействие (уменьшение суммы счёта)
     */
    public abstract void withdraw(BigDecimal sum, Account acc);

    /**
     * Метод возвращает сумму на конкретном счёте
     *
     * @param acc объект класса Account, у которого хотим узнать сумму
     */
    protected abstract BigDecimal getAmount(Account acc);

    /**
     * Метод переводит указанную сумму с одного указанного счета на другой
     *
     * @param sum     сумма, которую нужно перевести
     * @param accFrom объект класса Account, с чьего счёта хотим списать сумму
     * @param accTo   объект класса Account, на чей счёт хотим добавить сумму
     */
    void transfer(BigDecimal sum, Account accFrom, Account accTo) {
        withdraw(sum, accFrom);
        deposit(sum, accTo);
    }
}
