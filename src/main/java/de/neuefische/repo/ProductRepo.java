package de.neuefische.repo;

import de.neuefische.model.Product;

import java.util.*;

public class ProductRepo {

    private static Map<Integer, Product> products = new HashMap<>();



        static {
            Product product1 = new Product(1,"Toilet Paper");
            Product product2 = new Product(2,"Toothbrush");
            Product product3 = new Product(3,"Detergent");
            products = new HashMap<Integer, Product>() {
                {
                    put(product1.getId(), product1);
                    put(product2.getId(), product2);
                    put(product3.getId(), product3);
                }
            };
        }

        List<Product> list() {
            return new ArrayList<Product>(products.values());
        }

        public static Optional<Product> get(int id) {
            return Optional.ofNullable(products.get(id));
        }

}
