package de.neuefische.service;

import de.neuefische.model.Order;
import de.neuefische.model.Product;
import de.neuefische.repo.OrderRepo;
import de.neuefische.repo.ProductRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    ShopService generateShopService(){
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);
        return shopService;
    }

    @ParameterizedTest
    @CsvSource({
            "1, Toilet Paper",
            "2, Toothbrush",
            "3, Detergent"
    })
    public void testGetProductForValidProducts(int id, String expected){
        //GIVEN
        ShopService shopService = generateShopService();

        //WHEN
        Optional<Product> product = shopService.getProduct(id);
        String actual = product.get().getProductName();

        //THEN
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetProductForInvalidProducts(){
        //GIVEN
        int id = 100;
        Optional<Product> expected = Optional.empty();

        ShopService shopService = generateShopService();

        //WHEN
        Optional<Product> actual = shopService.getProduct(id);

        //THEN
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testListProducts(){
        //GIVEN
        ShopService shopService = generateShopService();
        String expected = "[id=1, productName='Toilet Paper', id=2, productName='Toothbrush', id=3, productName='Detergent']";

        //WHEN
        String actual = shopService.listProducts().toString();

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void testAddGetOrderForValidOrder(){
        //GIVEN
        ShopService shopService =  generateShopService();

        //WHEN

    }
}