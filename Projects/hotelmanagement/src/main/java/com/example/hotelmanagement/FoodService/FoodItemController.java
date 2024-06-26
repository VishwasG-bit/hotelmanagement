package com.example.hotelmanagement.FoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {
    @Autowired
    private FoodItemService foodItemService;

    @GetMapping
    public List<FoodItem> getAllFoodItems() {
        return foodItemService.getAllFoodItems();
    }

    @GetMapping("/available")
    public List<FoodItem> getAvailableFoodItems() {
        return foodItemService.getAvailableFoodItems();
    }

    @PostMapping("/order/{foodItemId}")
    public FoodItem orderFood(@PathVariable Long foodItemId) {
        return foodItemService.orderFood(foodItemId);
    }

}
