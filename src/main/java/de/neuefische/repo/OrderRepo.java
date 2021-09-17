package de.neuefische.repo;

import de.neuefische.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepo {
    private Map<Integer, Order> orders = new HashMap<>();

    public List<Order> list(){
        return orders.values();
    }

    public Order get(int id) {
        return Order.getId(id);
    }

    public void add(Order newOrder){
        orders.put(newOrder.getId(), newOrder);
    }

    public void add(List<Order> )

    public void add(Student student) {
        students.put(student.getId(), student);
    }

    public void add(List<Student> students) {
        for (Student student : students) {
            add(student);
        }
    }



}


