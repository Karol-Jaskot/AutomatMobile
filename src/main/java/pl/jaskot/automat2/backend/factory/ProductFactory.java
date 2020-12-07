package pl.jaskot.automat2.backend.factory;

import pl.jaskot.automat2.backend.entity.Product;

public class ProductFactory {

    public static Product createProduct(String name, int number, double price, String link){
        Product product = new Product(name, number, price, link);
        return product;
    }

}
