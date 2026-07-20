package com.example.paymentservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);
    private final Random random = new Random();

    @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
    public String processPayment(Double amount) {
        LOGGER.info("Attempting to process payment of ${} via third-party API...", amount);

        // Simulate a slow call or exception randomly
        int chance = random.nextInt(10);
        if (chance < 3) {
            // Slow call simulation
            try {
                LOGGER.warn("Slow call simulation: sleeping for 3 seconds...");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } else if (chance < 6) {
            // Failure call simulation
            LOGGER.error("Failed connection to third-party payment gateway!");
            throw new RuntimeException("Third-party payment gateway connection timeout");
        }

        return "Payment of $" + amount + " processed successfully!";
    }

    // Fallback logic for Resilience4j
    public String paymentFallback(Double amount, Throwable throwable) {
        LOGGER.error("Fallback event triggered for payment of ${} due to exception: {}", amount, throwable.getMessage());
        return "Payment of $" + amount + " failed. Fallback: Queueing transaction for offline processing.";
    }
}
