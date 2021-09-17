package de.neuefische.service;

import de.neuefische.model.Product;
import de.neuefische.repo.OrderRepo;
import de.neuefische.repo.ProductRepo;

public class ShopService {

    private ProductRepo productRepo;
    private OrderRepo orderRepo;


    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
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
