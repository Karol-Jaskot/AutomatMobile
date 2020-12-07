package pl.jaskot.automat2.backend.collections;

public interface MoneyCollection {

    void addMoney(double money);

    void subMoney(double money);

    double howManyMoney();

    void removeMoney();

}
