package com.lynda.common;

import checkout.CheckoutService;
import checkout.CheckoutServiceImplementation;
import item.ItemService;
import item.ItemServiceImplementation;
import order.OrderService;
import order.OrderServiceImplementation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/application.properties")
public class HelloConfig {

    @Value("${greeting.text}")
    private String greetingText;

    @Bean
    String getGreetingText() {
        return this.greetingText;
    }

    @Bean
    public String greeting() {
        return "world";
    }

    @Bean
    public ItemService itemService() {
        return new ItemServiceImplementation();
    }

    @Bean
    public OrderService orderService(ItemService itemService) {
        return new OrderServiceImplementation(itemService);
    }

    @Bean
    public CheckoutService getCheckoutService(OrderService orderService) {
        return new CheckoutServiceImplementation(orderService);
    }

    /*public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloConfig.class);
        CheckoutService checkoutService = (CheckoutService) context.getBean("getCheckoutService");
        OrderService orderService = checkoutService.doCheckout();
        System.out.println(orderService.placeOrder());
        System.out.println(orderService.placeOrder());
        System.out.println(orderService.placeOrder());
    }*/

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloConfig.class);
        String greetingText = (String) context.getBean("getGreetingText");
        System.out.println("Hello " + greetingText);
    }
}
