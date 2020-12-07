package pl.jaskot.automat2.backend.entity;

import lombok.Data;

@Data
public class Product {

    private final String name;
    private int howMany;
    private final double price;
    private final String imageLink;

    public Product(String name, int howMany, double price, String imageLink) {
        this.name = name;
        this.howMany = howMany;
        this.price = price;
        this.imageLink = imageLink;
    }

    public void takeOneProduct() {
        if (howMany <= 0) {
            throw new IllegalArgumentException("Brak podanego produktu!");
        } else {
            howMany--;
        }
    }
}
