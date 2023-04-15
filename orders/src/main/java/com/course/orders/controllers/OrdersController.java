package com.course.orders.controllers;


import com.course.orders.beans.OrderItem;
import com.course.orders.beans.Orders;
import com.course.orders.repositories.OrdersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class OrdersController {

    @Autowired
    OrdersRepository ordersRepository;


    @GetMapping(value = "/orders")
    public List<Orders> list()
    {
           List<Orders> productList = ordersRepository.findAll();

        return productList;
    }

    @PostMapping(value = "/addOrder")
    public void addOrder(@RequestBody Orders order)
    {



              ordersRepository.save(order);

    }

}
