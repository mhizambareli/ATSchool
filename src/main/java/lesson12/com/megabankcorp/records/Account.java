package lesson12.com.megabankcorp.records;

import java.math.BigDecimal;

/**
 * ЗАДАНИЕ 64.1:
 * Представим, что вы занимаетесь проектированием банковской системы учета.
 * Ваша задача описать базовые классы, на основании которых могут делаться остальные.
 * Спроектируйте классы Account (счет) и Database (база данных) согласно описанию:
 *
 * Account
 *     это простой класс, который находится в пакете com.megabankcorp.records
 *     содержит
 *         поле для текущей суммы на счете
 *         поле для текущего номера счета
 *         поле для номера клиента банка
 *
 *     Для суммы используйте тип BigDecimal, для номеров - long
 */
public class Account {
    private BigDecimal currentAmount;
    private long accountId;
    private long clientId;

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public long getAccountId() {
        return accountId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }
}
