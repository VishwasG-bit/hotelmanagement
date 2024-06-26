package com.example.hotelmanagement.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bills")
public class BillController {
    @Autowired
    private BillService billService;

    @PostMapping("/generate")
    public Bill generateBill(@RequestParam Long roomId, @RequestParam Long foodItemId, @RequestParam double amount) {
        return billService.generateBill(roomId, foodItemId, amount);
    }
}
