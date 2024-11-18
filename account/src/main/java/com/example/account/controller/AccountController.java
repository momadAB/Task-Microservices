package com.example.account.controller;

import com.example.account.bo.AccountResponse;
import com.example.account.bo.Stock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class AccountController {

    private static final String STOCK_API = "http://localhost:8080/api/get-stock";
    private final RestTemplate restTemplate;

    public AccountController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/account")
    public ResponseEntity<AccountResponse> account() {
        try {
            // Make GET request to fetch stock details
            ResponseEntity<Stock[]> responseEntity = restTemplate.getForEntity(STOCK_API, Stock[].class);

            // Convert array to list
            Stock[] stockArray = responseEntity.getBody();
            AccountResponse accountResponse = new AccountResponse();
            accountResponse.setStocks(Arrays.asList(stockArray));
            accountResponse.setStatus("Success");

            // Log the response
            System.out.println("Account Response:: " + accountResponse);

            return ResponseEntity.status(HttpStatus.OK).body(accountResponse);
        } catch (Exception e) {
            AccountResponse accountResponse = new AccountResponse();
            accountResponse.setStatus("Failure");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(accountResponse);
        }
    }
}
