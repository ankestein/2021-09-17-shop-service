package de.neuefische.repo;

import de.neuefische.model.Product;

import java.util.*;

public class ProductRepo {

    public Map<Integer, Product> products = new HashMap<>();

    public ProductRepo(List<Product> productsInput) {
        for (Product product : productsInput) {
            products.put(product.getId(), product);
        }
    }

    public List<Product> list() {
        return new ArrayList<Product>(products.values());
    }

    public Optional<Product> get(int id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }
}
