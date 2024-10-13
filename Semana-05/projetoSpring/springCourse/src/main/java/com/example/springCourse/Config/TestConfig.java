package com.example.springCourse.Config;

import com.example.springCourse.Entities.Order;
import com.example.springCourse.Entities.User;
import com.example.springCourse.Entities.enums.OrderStatus;
import com.example.springCourse.Repositories.OrderRepository;
import com.example.springCourse.Repositories.UserRepository;
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

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Luciano", "Luciano@gmail.com", "8381919", "7192712222");
        User user2 = new User(null, "Gabriel", "Gbiel@gmail.com", "21151", "7192713332");
        User user3 = new User(null, "Carlos", "carlos@gmail.com", "13151", "7192222");
        userRepository.saveAll(Arrays.asList(user1, user2));

        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),user1, OrderStatus.PAID);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), user2, OrderStatus.WAITING_PAYMENT);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), user3, OrderStatus.CANCELED);
        orderRepository.saveAll(Arrays.asList(order1, order2));


    }
}
