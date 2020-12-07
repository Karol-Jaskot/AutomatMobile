package pl.jaskot.automat2.backend.collections;

import pl.jaskot.automat2.backend.entity.Money;
import pl.jaskot.automat2.backend.services.MathService;

public class MoneyCollectionImpl implements MoneyCollection{

    private Money money;

    public MoneyCollectionImpl() {
        money = new Money();
        money.setValue(0.0);
    }

    public void addMoney(double coins) {
        if(coins<0){
            throw new IllegalArgumentException("Ujemna kwota wpłaty!");
        } else {
            double newMoney = money.getValue()+coins;
            newMoney = MathService.roundToDecimal(newMoney, 1);
            money.setValue(newMoney);
        }
    }

    public void subMoney(double coins) {
        if (coins > money.getValue()) {
            throw new IllegalArgumentException("Brak pieniędzy w systemie!");
        } else {
            double newMoney = money.getValue()-coins;
            newMoney = MathService.roundToDecimal(newMoney, 1);
            money.setValue(newMoney);
        }
    }

    public double howManyMoney() {
        return money.getValue();
    }

    public void removeMoney() {
        money.setValue(0.0);
    }
}