package me.cc.payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @GetMapping("/health")
    public String healthCheck() {
        return "Healthy!";
    }
}
