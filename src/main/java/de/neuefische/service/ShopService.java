package de.neuefische.service;

import de.neuefische.model.Order;
import de.neuefische.model.Product;
import de.neuefische.repo.OrderRepo;
import de.neuefische.repo.ProductRepo;

import java.util.HashMap;
import java.util.Map;

public class ShopService {

    private Map<Integer, Product> productRepo = new HashMap<>();
    private Map<Integer, Order> orderRepo = new HashMap<>();

    public ShopService(Map<Integer, Product> productRepo, Map<Integer, Order> orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public String getProduct(){
        return null;
    }

    public void listProduct(){

    }

    public void addOrder(){

    }

    public void getOrder(){

    }

    public void listOrders(){

    }
}
