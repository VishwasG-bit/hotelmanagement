package com.example.hotelmanagement.FoodService;

import com.example.hotelmanagement.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {
    @Autowired
    private FoodItemRepository foodItemRepository;

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public List<FoodItem> getAvailableFoodItems() {

        return foodItemRepository.findByAvailable(true);
    }

    public FoodItem orderFood(Long foodItemId) {
        FoodItem foodItem = foodItemRepository.findById(foodItemId).orElseThrow(() ->
            new ResourceNotFoundException("Food item not found")
        );
        foodItem.setAvailable(false);
        return foodItemRepository.save(foodItem);

    }
}

