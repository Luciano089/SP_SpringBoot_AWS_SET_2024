package com.example.springCourse.Config;

import com.example.springCourse.Entities.*;
import com.example.springCourse.Entities.enums.OrderStatus;
import com.example.springCourse.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Eletronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "fitnes");
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));

        Product product1 = new Product(null, "Lord of the rings", "Lorem ipsum dolor sit amet, consectetur", 90.5, "");
        Product product2 = new Product(null,"Smart TV", "Lorem ipsum dolor sit amet, consectetur", 9000.5, "");
        Product product3 = new Product(null, "MacBook", "Lorem ipsum dolor sit amet, consectetur", 8270.5, "");

        product1.getCategories().add(category2);
        product2.getCategories().add(category3);
        product3.getCategories().add(category1);

        productRepository.saveAll(Arrays.asList(product1, product2, product3));

        User user1 = new User(null, "Luciano", "Luciano@gmail.com", "8381919", "7192712222");
        User user2 = new User(null, "Gabriel", "Gbiel@gmail.com", "21151", "7192713332");
        User user3 = new User(null, "Carlos", "carlos@gmail.com", "13151", "7192222");
        userRepository.saveAll(Arrays.asList(user1, user2));

        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),user1, OrderStatus.PAID);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), user2, OrderStatus.WAITING_PAYMENT);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), user3, OrderStatus.CANCELED);
        orderRepository.saveAll(Arrays.asList(order1, order2));

        OrderItem orderItem1 = new OrderItem(order1, product1, 2, product1.getPrice());
        OrderItem orderItem2 = new OrderItem(order1, product3, 1, product3.getPrice());
        OrderItem orderItem3 = new OrderItem(order2, product3, 2, product3.getPrice());

        orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3));



    }
}
