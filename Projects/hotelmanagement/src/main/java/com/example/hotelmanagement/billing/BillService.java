package com.example.hotelmanagement.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public Bill generateBill(Long roomId, Long foodItemId, double amount){

        Bill bill= new Bill();
        bill.setRoomID(roomId);
        bill.setFoodItemID(foodItemId);
        bill.setAmount(amount);
        return billRepository.save(bill);
    }
}
