package pl.jaskot.automat2.backend.services;

import pl.jaskot.automat2.backend.entity.Product;
import pl.jaskot.automat2.backend.factory.ProductsGenerator;

import java.util.List;

public class ProductService {

    private List<Product> products;

    public ProductService() {
        products = ProductsGenerator.createProductsList();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public void takeOneProduct(Product product) {
        product.takeOneProduct();
    }
}