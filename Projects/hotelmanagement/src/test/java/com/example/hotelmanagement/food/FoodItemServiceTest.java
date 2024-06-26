package com.example.hotelmanagement.food;


import com.example.hotelmanagement.FoodService.FoodItem;
import com.example.hotelmanagement.FoodService.FoodItemRepository;
import com.example.hotelmanagement.FoodService.FoodItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FoodItemServiceTest {

    @Mock
    private FoodItemRepository foodItemRepository;

    @InjectMocks
    private FoodItemService foodItemService;

    @Test
    public void testGetAllFoodItems() {
        FoodItem item1 = new FoodItem();
        FoodItem item2 = new FoodItem();

        when(foodItemRepository.findAll()).thenReturn(Arrays.asList(item1, item2));
        List<FoodItem> items = foodItemService.getAllFoodItems();

        assertEquals(2, items.size());
        verify(foodItemRepository, times(1)).findAll();
    }

    @Test
    public void testGetAvailableFoodItems() {
        FoodItem item1 = new FoodItem();
        FoodItem item2 = new FoodItem();

        when(foodItemRepository.findByAvailable(true)).thenReturn(Arrays.asList(item1, item2));
        List<FoodItem> items = foodItemService.getAvailableFoodItems();

        assertEquals(2, items.size());
        verify(foodItemRepository, times(1)).findByAvailable(true);
    }


    @Test
    public void  testOrderFood(){

        FoodItem item = new FoodItem();
        item.setId(1L);
        item.setAvailable(true);

        when(foodItemRepository.findById(1L)).thenReturn(Optional.of(item));

        when(foodItemRepository.save(any(FoodItem.class))).thenReturn(item);

        FoodItem orderedItem = foodItemService.orderFood(1L);
        assertFalse(orderedItem.isAvailable());
        verify(foodItemRepository,times(1)).findById(1L);
        verify(foodItemRepository, times(1)).save(item);
    }
}
