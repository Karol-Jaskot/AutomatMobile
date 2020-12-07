package pl.jaskot.automat2.backend.factory;

import pl.jaskot.automat2.backend.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsGenerator {

    public static List<Product> createProductsList(){
        List<Product> products = new ArrayList<>();
        products.add(ProductFactory.createProduct("Cola", 4, 2.0, "https://image.ceneostatic.pl/data/products/17174188/i-coca-cola-puszka-0-33l.jpg"));
        products.add(ProductFactory.createProduct("Tymbark", 6, 1.5, "http://www.leclerc.rzeszow.pl/foto_shop/126/5900334000767_T1.jpg"));
        products.add(ProductFactory.createProduct("Sprite", 2, 2.6, "https://www.biurfan.pl/dane/full/f/fac6e1bb92404c419549208fb12ad7a7.jpg"));
        products.add(ProductFactory.createProduct("Pepsi", 1, 2.0, "https://internetowysupermarket.pl/pol_pl_Pepsi-Cola-Napoj-gazowany-330ml-7136_1.png"));
        products.add(ProductFactory.createProduct("Piwniczanka", 7, 1.2, "https://jedzpij.pl/environment/cache/images/500_500_productGfx_a3c35c5ed9740509191f800ac51174e4.jpg"));
        products.add(ProductFactory.createProduct("Kubus", 2, 2.2, "https://image.ceneostatic.pl/data/products/15170568/i-maspex-sok-kubus-go-300ml-banan-truskawka-pet.jpg"));
        return products;
    }


}
