package pl.jaskot.automat2.backend.services.interfaces;

public interface MoneyServiceInterface {

    double showClientMoney();
    void addClientMoney(double money);
    void removeMoney();
    void payForProduct(double price);

}
