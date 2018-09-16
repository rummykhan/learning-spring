package order;

import item.ItemService;

public class OrderServiceImplementation implements OrderService {

    private ItemService itemService;

    public OrderServiceImplementation(ItemService itemService) {
        this.itemService = itemService;
    }

    public String placeOrder() {
        return "Order placed and items are " + this.itemService.getName();
    }
}
