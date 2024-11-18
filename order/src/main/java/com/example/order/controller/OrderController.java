package com.example.order.controller;

import com.example.order.bo.OrderResponse;
import com.example.order.bo.CreateOrderRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private static final String STOCK_API = "http://localhost:8080/api/updateStock";
    private final RestTemplate restTemplate;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/orders")
    public OrderResponse doOrder(@RequestBody CreateOrderRequest customerOrder) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CreateOrderRequest> request = new HttpEntity<>(customerOrder, headers);

        ResponseEntity<OrderResponse> responseEntity = restTemplate.postForEntity(STOCK_API, request, OrderResponse.class);
        OrderResponse orderStatus = responseEntity.getBody();

        System.out.println("Order Status::" + orderStatus);

        return orderStatus;
    }
}