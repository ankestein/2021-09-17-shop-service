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

    @Test
    public void testAddOrder(){
        // given
        Order order1 = new Order(1, new Product(111, "bookA"));
        Order order2 = new Order(2, new Product(222, "pencil"));
        OrderRepo orderRepo = new OrderRepo(List.of(order1, order2));
        Order order3 = new Order(3, new Product(333, "computer"));
        // when
        orderRepo.add(order3);
        List<Order> actual = orderRepo.list();
        // then
        List<Order> expected = new ArrayList<>(List.of(order1, order2, order3));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAddFirstOrder(){
        // given
        Order order1 = new Order(1, new Product(111, "bookA"));
        OrderRepo orderRepo = new OrderRepo();
        // when
        orderRepo.add(order1);
        List<Order> actual = orderRepo.list();
        // then
        List<Order> expected = new ArrayList<>(List.of(order1));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAddOrderWithSameIdException() {
        // given
        Order order1 = new Order(1, new Product(111, "bookA"));
        Order order2 = new Order(2, new Product(222, "pencil"));
        OrderRepo orderRepo = new OrderRepo(List.of(order1, order2));
        // when
        try {
            orderRepo.add(new Order(2, new Product(222, "stapler")));
            fail("Exception not thrown!");
        } catch (RuntimeException e) {
            String actual = e.getMessage();
            String expected = "Cannot place order; order with id 2 already exists.";
            Assertions.assertEquals(expected, actual);
        }
    }

    @Test
    public void testAddOrderList(){
        // given
        Order order1 = new Order(1, new Product(111, "bookA"));
        Order order2 = new Order(2, new Product(222, "pencil"));
        OrderRepo orderRepo = new OrderRepo(List.of(order1, order2));
        Order order3 = new Order(3, new Product(333, "computer"));
        Order order4 = new Order(4, new Product(115, "keyboard"));
        List<Order> newOrders = new ArrayList<>(List.of(order3, order4));
        // when
        orderRepo.add(newOrders);
        List<Order> actual = orderRepo.list();
        // then
        List<Order> expected = new ArrayList<>(List.of(order1, order2, order3, order4));
        Assertions.assertEquals(expected, actual);
    }

}