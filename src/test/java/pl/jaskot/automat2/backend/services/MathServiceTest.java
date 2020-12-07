package pl.jaskot.automat2.backend.services;

import org.junit.Assert;
import org.junit.Test;

public class MathServiceTest {

    @Test
    public void roundToDecimal(){
       double number = MathService.roundToDecimal(5, 0);
        Assert.assertEquals(5, number, 0);
    }

    @Test
    public void roundToDecimalSecond(){
        double number = MathService.roundToDecimal(5.222 , 1);
        Assert.assertEquals(5.2 , number, 0.1);
    }

}