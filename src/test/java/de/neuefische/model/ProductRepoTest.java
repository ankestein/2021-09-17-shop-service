package de.neuefische.model;

import de.neuefische.repo.ProductRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.fail;

public class ProductRepoTest {

    @Test
    public void runTestForList() {
        //GIVEN
        String expected = "[id=1, productName='Toilet Paper', id=2, productName='Toothbrush', id=3, productName='Detergent']";
        //WHEN
        ProductRepo productRepo = new ProductRepo();
        String actual = ProductRepo.list().toString();
        //THEN
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1, T-Shirt",
            "2, Jacket",
            "4, not found"
    })
    public void runTestForGetProduct(int id, String expected){
        //WHEN
        Product product1 = new Product(1, "T-Shirt");
        Product product2 = new Product(2, "Jacket");
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        ShopService shopService = new ShopService(new ProductRepo(products));
        String actual = shopService.getProduct(id).getProductName();
        //THEN
        Assertions.assertEquals(expected, actual);
    }
}
