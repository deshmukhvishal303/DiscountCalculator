package com.cdk.entity;

import com.cdk.entity.discount.DiscountSlab;
import com.cdk.util.BillCalculator;
import lombok.Data;

import java.util.Set;
import java.util.TreeSet;

@Data
public class Customer {
    private static BillCalculator billCalculator = new BillCalculator();

    private Integer purchaseAmount;

    private Set<DiscountSlab> discountSlab = new TreeSet<>();

    public Integer calculateBillAmount() {
        return billCalculator.calculateBillAmount(purchaseAmount, discountSlab);
    }
}
