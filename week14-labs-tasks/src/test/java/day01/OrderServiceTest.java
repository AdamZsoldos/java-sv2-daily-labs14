package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    OrderService orderService;

    @BeforeEach
    void init() {
        orderService = new OrderService();

        Product p1 = new Product("Tv", "IT", 2000);
        Product p2 = new Product("Laptop", "IT", 2400);
        Product p3 = new Product("Phone", "IT", 400);
        Product p4 = new Product("Lord of The Rings", "Book", 20);
        Product p5 = new Product("Harry Potter Collection", "Book", 120);

        Order o1 = new Order("pending", LocalDate.of(2021, 6, 7));
        o1.addProduct(p1);
        o1.addProduct(p2);
        o1.addProduct(p5);

        Order o2 = new Order("on delivery", LocalDate.of(2021, 6, 1));
        o2.addProduct(p3);
        o2.addProduct(p1);
        o2.addProduct(p2);

        Order o3 = new Order("pending", LocalDate.of(2021, 6, 7));
        o3.addProduct(p1);
        o3.addProduct(p2);
        o3.addProduct(p5);

        Order o4 = new Order("on delivery", LocalDate.of(2021, 6, 1));
        o4.addProduct(p3);
        o4.addProduct(p1);
        o4.addProduct(p4);
        o4.addProduct(p2);

        Order o5 = new Order("pending", LocalDate.of(2021, 6, 7));
        o5.addProduct(p1);
        o5.addProduct(p2);
        o5.addProduct(p5);

        orderService.saveOrder(o1);
        orderService.saveOrder(o2);
        orderService.saveOrder(o3);
        orderService.saveOrder(o4);
        orderService.saveOrder(o5);
    }

    @Test
    void testGetOrdersByStatus() {
        assertEquals(
                List.of(orderService.getOrders().get(1), orderService.getOrders().get(3)),
                orderService.getOrdersByStatus("on delivery")
        );
    }

    @Test
    void testCountOrdersByStatus() {
        assertEquals(3, orderService.countOrdersByStatus("pending"));
        assertEquals(2, orderService.countOrdersByStatus("on delivery"));
    }

    @Test
    void testGetOrdersByDate() {
        assertEquals(
                List.of(orderService.getOrders().get(1), orderService.getOrders().get(3)),
                orderService.getOrdersByDate(LocalDate.of(2021, 5, 10), LocalDate.of(2021, 6, 1))
        );
        assertEquals(
                List.of(),
                orderService.getOrdersByDate(LocalDate.of(2021, 5, 10), LocalDate.of(2021, 5, 31))
        );
    }

    @Test
    void testHasOrderWithNoMoreProductsThan() {
        assertTrue(orderService.hasOrderWithNoMoreProductsThan(3));
        assertFalse(orderService.hasOrderWithNoMoreProductsThan(2));
    }

    @Test
    void testGetOrderWithMostProducts() {
        assertSame(orderService.getOrders().get(3), orderService.getOrderWithMostProducts());
    }

    @Test
    void testGetOrdersWithProductCategory() {
        assertEquals(
                List.of(orderService.getOrders().get(0), orderService.getOrders().get(2), orderService.getOrders().get(3), orderService.getOrders().get(4)),
                orderService.getOrdersWithProductCategory("Book")
        );
    }
}
