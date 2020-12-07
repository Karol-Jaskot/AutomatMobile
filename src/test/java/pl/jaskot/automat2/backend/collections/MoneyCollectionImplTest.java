package pl.jaskot.automat2.backend.collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoneyCollectionImplTest {

    private MoneyCollection moneyCollection;

    @Before
    public void startTests(){
        moneyCollection = new MoneyCollectionImpl();
    }

    @Test
    public void emptyToStart(){
        Assert.assertEquals(0, moneyCollection.howManyMoney(), 0);
    }

    @Test
    public void addFiveMoney(){
        moneyCollection.addMoney(5);
        Assert.assertEquals(5, moneyCollection.howManyMoney(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMinusFiveMoney(){
        moneyCollection.addMoney(- 5);
    }

    @Test
    public void addAndSubMoney(){
        moneyCollection.addMoney(10);
        moneyCollection.subMoney(10);
        Assert.assertEquals(0, moneyCollection.howManyMoney(), 0);
    }

    @Test
    public void addFiveSubTwo(){
        moneyCollection.addMoney(5);
        moneyCollection.subMoney(2);
        Assert.assertEquals(3, moneyCollection.howManyMoney(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void subTooManyMoney(){
        moneyCollection.addMoney(5);
        moneyCollection.subMoney(10);
    }

    @Test
    public void moneyRemove(){
        moneyCollection.addMoney(5);
        moneyCollection.removeMoney();
        Assert.assertEquals(0, moneyCollection.howManyMoney(), 0);
    }

}
