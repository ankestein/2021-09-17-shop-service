package de.neuefische.service;

import de.neuefische.model.Order;
import de.neuefische.model.Product;
import de.neuefische.repo.OrderRepo;
import de.neuefische.repo.ProductRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopService {

    private Map<Integer, Product> productRepo = new HashMap<>();
    private Map<Integer, Order> orderRepo = new HashMap<>();

    public ShopService(Map<Integer, Product> productRepo, Map<Integer, Order> orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Product getProduct(int id){
        return productRepo.get(id);
    }

    public List<Product> listProducts(){
        return new ArrayList<>(productRepo.values());
    }

    public void addOrder(int id, Order value){
        orderRepo.put(id, value);
    }

    public Order getOrder(int id){
        return orderRepo.get(id);
    }

    public List<Order> listOrders(){
        return new ArrayList<>(orderRepo.values());
    }
}
