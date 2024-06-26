package com.example.hotelmanagement.billing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BillServiceTest {

    @Mock
    private BillRepository billRepository;

    @InjectMocks
    private BillService billService;

    @Test

    public void testGenerateBill(){

        Bill bill = new Bill();
        bill.setId(1L);
        bill.setRoomID(101L);
        bill.setFoodItemID(202L);
        bill.setAmount(150.0);

        when(billRepository.save(any(Bill.class))).thenReturn(bill);

        Bill generatedBill = billService.generateBill(101L, 202L, 150.0);

        assertEquals(1L, generatedBill.getId());
        assertEquals(101L, generatedBill.getRoomID());
        assertEquals(202L, generatedBill.getFoodItemID());
        assertEquals(150.0, generatedBill.getAmount());

        verify(billRepository,times(1)).save(any(Bill.class));

    }
}
