package checkout;

import item.ItemService;
import order.OrderService;
import order.OrderServiceImplementation;

public class CheckoutServiceImplementation implements CheckoutService {

    private OrderService orderService;
    public CheckoutServiceImplementation(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderService doCheckout() {
        return this.orderService;
    }
}
