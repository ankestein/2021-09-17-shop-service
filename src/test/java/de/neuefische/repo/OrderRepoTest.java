package de.neuefische.repo;

import de.neuefische.model.Order;
import de.neuefische.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {
    @Test
    public void testListOrders(){
        // given
        Order order1 = new Order(1, new Product(111, "bookA"));
        Order order2 = new Order(2, new Product(222, "pencil"));
        OrderRepo orderRepo = new OrderRepo(List.of(order1, order2));
        // when
        List<Order> actual = orderRepo.list();
        // then
        List<Order> expected = new ArrayList<>(List.of(order1, order2));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testListZeroOrders(){
        // given
        OrderRepo orderRepo = new OrderRepo();
        // when
        List<Order> actual = orderRepo.list();
        // then
        List<Order> expected = new ArrayList<>();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetOrder(){
        // given
        Order order1 = new Order(1, new Product(111, "bookA"));
        Order order2 = new Order(2, new Product(222, "pencil"));
        OrderRepo orderRepo = new OrderRepo(List.of(order1, order2));
        // when
        Order actual = orderRepo.get(2);
        // then
        Order expected = order2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetNonExistingOrder(){
        // given
        Order order1 = new Order(1, new Product(111, "bookA"));
        Order order2 = new Order(2, new Product(222, "pencil"));
        OrderRepo orderRepo = new OrderRepo(List.of(order1, order2));
        // when
        Order actual = orderRepo.get(3);
        // then
        Order expected = null;
        Assertions.assertEquals(expected, actual);
    }




}