package de.neuefische.springshop;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepo {

    private List<Order> orders;

    OrderRepo(){
        this.orders = new ArrayList<>();
    }

    public List<Order> getOrders(){
        return orders;
    }

    public Optional<List<Product>> get(int index) {
        for (Order order : orders){
            if(order.getId() == index){
                return Optional.of(order.getProducts());
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return orders + "";
    }
}
