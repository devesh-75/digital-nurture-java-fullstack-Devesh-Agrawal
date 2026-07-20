package com.example.customerservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping
    public List<String> getCustomers() {
        return Arrays.asList("Alice Smith", "Bob Jones", "Charlie Brown");
    }
}
