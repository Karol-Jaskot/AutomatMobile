package pl.jaskot.automat2.backend.factory;

import org.junit.Assert;
import org.junit.Test;
import pl.jaskot.automat2.backend.entity.Product;

public class ProductFactoryTest {

    @Test
    public void productFromFactory(){
        Product firstProduct = new Product("Product", 2,5, "link");
        Product secondProduct = ProductFactory.createProduct("Product", 2,5, "link");
        Assert.assertEquals(firstProduct, secondProduct);
    }


}
