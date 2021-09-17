package de.neuefische.repo;

import de.neuefische.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepo {
    private Map<Integer, Order> orders = new HashMap<>();


    public OrderRepo(List<Order> orders) {
        add(orders);
    }

    public OrderRepo(){
    }

    public List<Order> list(){
        return new ArrayList<>(orders.values());
    }

    public Order get(int id) {
        return orders.get(id);
    }

    public void add(Order order){
        if (this.orders.containsKey(order.getId())) {
            throw new RuntimeException("Cannot place order; order with id " + order.getId() + " already exists.");
        }
        orders.put(order.getId(), order);
    }

    public void add(List<Order> orders) {
        for (Order order : orders) {
            add(order);
        }
    }

}


