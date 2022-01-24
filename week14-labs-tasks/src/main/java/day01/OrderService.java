package day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderService {

    private final List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public void saveOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrdersByStatus(String status) {
        return orders.stream()
                .filter(order -> order.getStatus().equals(status))
                .toList();
    }

    public long countOrdersByStatus(String status) {
        return orders.stream()
                .filter(order -> order.getStatus().equals(status))
                .count();
    }

    public List<Order> getOrdersByDate(LocalDate start, LocalDate end) {
        return orders.stream()
                .filter(order -> !order.getOrderDate().isBefore(start))
                .filter(order -> !order.getOrderDate().isAfter(end))
                .toList();
    }

    public boolean hasOrderWithNoMoreProductsThan(int max) {
        return orders.stream().anyMatch(order -> order.getProducts().size() <= max);
    }

    public Order getOrderWithMostProducts() {
        return orders.stream()
                .max(Comparator.comparingInt(o -> o.getProducts().size()))
                .orElseThrow(() -> new IllegalStateException("Has no orders"));
    }
}
