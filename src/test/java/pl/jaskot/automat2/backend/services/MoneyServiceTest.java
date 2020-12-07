package pl.jaskot.automat2.backend.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoneyServiceTest {

    MoneyService moneyService;

    @Before
    public void startTests(){
        moneyService = new MoneyService();
    }

    @Test
    public void emptyClientMoneyOnStart(){
        Assert.assertEquals(0, moneyService.showClientMoney(), 0);
    }

    @Test
    public void addClientMoney(){
        moneyService.addClientMoney(50);
        Assert.assertEquals(50, moneyService.showClientMoney(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMinusMoney(){
        moneyService.addClientMoney(- 5);
    }

    @Test
    public void removeMoney() {
        moneyService.addClientMoney(50);
        moneyService.removeMoney();
        Assert.assertEquals(0, moneyService.showClientMoney(), 0);
    }

    @Test
    public void payForProduct() {
        moneyService.addClientMoney(10);
        moneyService.payForProduct(4);
        Assert.assertEquals(6, moneyService.showClientMoney(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void payForProductMinusPrice() {
        moneyService.payForProduct( - 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notEnoughtMoneyToPay() {
        moneyService.payForProduct(5);
    }
}