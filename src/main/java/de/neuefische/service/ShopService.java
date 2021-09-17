package de.neuefische.service;

import de.neuefische.model.Order;
import de.neuefische.model.Product;
import de.neuefische.repo.OrderRepo;
import de.neuefische.repo.ProductRepo;

import java.util.*;

public class ShopService {

    private ProductRepo productRepo = new ProductRepo();
    private OrderRepo orderRepo = new OrderRepo();

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Optional<Product> getProduct(int id){
        return productRepo.get(id);
    }

    public List<Product> listProducts(){
        return productRepo.list();
    }

    public void addOrder(Order order){
        orderRepo.add(order);
    }

    public Order getOrder(int id){
        return null;
    }

    public List<Order> listOrders(){
        return null;
    }
}
