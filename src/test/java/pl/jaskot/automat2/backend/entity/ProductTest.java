package pl.jaskot.automat2.backend.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {

    private Product product;

    @Before
    public void startTests(){
        product = new Product("Product", 2,5, "link");
    }

    @Test
    public void create(){
        Assert.assertEquals("Product", product.getName());
        Assert.assertEquals(2, product.getHowMany(), 0);
        Assert.assertEquals(5, product.getPrice(), 0);
        Assert.assertEquals("link", product.getImageLink());
    }

    @Test
    public void takeOneProduct(){
        product.takeOneProduct();
        Assert.assertEquals(1, product.getHowMany(), 0);
    }

    @Test
    public void takeAllProduct(){
        while(product.getHowMany()>0){
            product.takeOneProduct();
        }
        Assert.assertEquals(0, product.getHowMany(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void takeTooMuchProducts(){
        while(product.getHowMany()>-1){
            product.takeOneProduct();
        }
    }
}
