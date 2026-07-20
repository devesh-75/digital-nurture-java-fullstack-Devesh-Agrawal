package com.example.billingservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @GetMapping
    public List<String> getBills() {
        return Arrays.asList("Invoice #1001: $150.00", "Invoice #1002: $45.50", "Invoice #1003: $320.00");
    }
}
