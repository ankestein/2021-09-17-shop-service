package de.neuefische.service;

import de.neuefische.model.Order;
import de.neuefische.model.Product;
import de.neuefische.repo.OrderRepo;
import de.neuefische.repo.ProductRepo;

import java.util.*;

public class ShopService {

   // private Map<Integer, Product> productRepo = new HashMap<>();
   public static ProductRepo productRepo;

    private Map<Integer, Order> orderRepo = new HashMap<>();

    public ShopService(Map<Integer, Product> productRepo, Map<Integer, Order> orderRepo) {
        //this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public ShopService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public ShopService(){};

    public Product getProduct(int id) {
        if (productRepo.get(id).isPresent()) {
            return productRepo.get(id).get();
        } else {
            return new Product(0, "not found");
        }
    }
    public void listProduct(){
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
