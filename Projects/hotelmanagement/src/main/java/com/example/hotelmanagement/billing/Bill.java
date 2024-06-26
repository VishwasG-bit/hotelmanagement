package com.example.hotelmanagement.billing;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    private Long roomID;
    private Long FoodItemID;
    private double amount;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomID() {
        return roomID;
    }

    public void setRoomID(Long roomID) {
        this.roomID = roomID;
    }

    public Long getFoodItemID() {
        return FoodItemID;
    }

    public void setFoodItemID(Long foodItemID) {
        FoodItemID = foodItemID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
