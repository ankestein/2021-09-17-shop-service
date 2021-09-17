package de.neuefische.repo;

import de.neuefische.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepo {
    private Map<Integer, Order> orders = new HashMap<>();

    public List<Order> list(){
        return new ArrayList<>(orders.values());
    }

    public Order get(int id) {
        for (Order order : orders){
            if(order.getId() == id) {
                return order;
            }
        }
    }

    public void add(Order order){
        orders.put(order.getId(), order);
    }

}


