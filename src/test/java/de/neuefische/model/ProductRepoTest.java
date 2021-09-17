package de.neuefische.model;

import de.neuefische.repo.ProductRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
            "1, Toilet Paper",
            "2, Toothbrush",
            "3, Detergent",
            "4, No matching product found."
    })
    public void runTestForGetProduct(int id, String expected){
        //WHEN
        String actual;
        ProductRepo productRepo = new ProductRepo();
        Optional<Product> optionalProduct = productRepo.get(id);
        if (optionalProduct.isPresent()) {
            actual = optionalProduct.get().getProductName();
        } else {
            actual = "No matching product found.";
        }
        //THEN
        Assertions.assertEquals(expected, actual);
    }
}
