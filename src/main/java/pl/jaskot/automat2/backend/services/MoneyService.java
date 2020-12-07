package pl.jaskot.automat2.backend.services;

import pl.jaskot.automat2.backend.collections.MoneyCollection;
import pl.jaskot.automat2.backend.collections.MoneyCollectionImpl;
import pl.jaskot.automat2.backend.services.interfaces.MoneyServiceInterface;

public class MoneyService implements MoneyServiceInterface {

    private final MoneyCollection automatMoney;
    private final MoneyCollection clientMoney;

    public MoneyService() {
        automatMoney = new MoneyCollectionImpl();
        clientMoney = new MoneyCollectionImpl();
    }

    public double showClientMoney() {
        return clientMoney.howManyMoney();
    }

    public void addClientMoney(double money) {
        clientMoney.addMoney(money);
    }

    public void removeMoney() {
        clientMoney.removeMoney();
    }

    public void payForProduct(double price) {
        automatMoney.addMoney(price);
        clientMoney.subMoney(price);
    }
}